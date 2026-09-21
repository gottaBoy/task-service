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
import net.ibizsys.pscore.srv.config.entity.PSCssCatTempl;
import net.ibizsys.pscore.srv.config.service.PSCssCatTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCssTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCssTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSNAME = "CSSNAME";
    public static final String FIELD_CSSSTYLE = "CSSSTYLE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCSSCATTEMPLID = "PSCSSCATTEMPLID";
    public static final String FIELD_PSCSSCATTEMPLNAME = "PSCSSCATTEMPLNAME";
    public static final String FIELD_PSCSSTEMPLID = "PSCSSTEMPLID";
    public static final String FIELD_PSCSSTEMPLNAME = "PSCSSTEMPLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CSSNAME = 2;
    private static final int INDEX_CSSSTYLE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSCSSCATTEMPLID = 5;
    private static final int INDEX_PSCSSCATTEMPLNAME = 6;
    private static final int INDEX_PSCSSTEMPLID = 7;
    private static final int INDEX_PSCSSTEMPLNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCssTemplBase proxyPSCssTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssnameDirtyFlag = false;
    private boolean cssstyleDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscsscattemplidDirtyFlag = false;
    private boolean pscsscattemplnameDirtyFlag = false;
    private boolean pscsstemplidDirtyFlag = false;
    private boolean pscsstemplnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssname")
    private String cssname;
    @Column(name="cssstyle")
    private String cssstyle;
    @Column(name="memo")
    private String memo;
    @Column(name="pscsscattemplid")
    private String pscsscattemplid;
    @Column(name="pscsscattemplname")
    private String pscsscattemplname;
    @Column(name="pscsstemplid")
    private String pscsstemplid;
    @Column(name="pscsstemplname")
    private String pscsstemplname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSCssCatTemplLock = new Integer(1);
    private PSCssCatTempl pscsscattempl = null;

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

    public void setCSSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssname = string;
        this.cssnameDirtyFlag = true;
    }

    public String getCSSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSSName();
        }
        return this.cssname;
    }

    public boolean isCSSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSSNameDirty();
        }
        return this.cssnameDirtyFlag;
    }

    public void resetCSSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSSName();
            return;
        }
        this.cssnameDirtyFlag = false;
        this.cssname = null;
    }

    public void setCSSStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSSStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssstyle = string;
        this.cssstyleDirtyFlag = true;
    }

    public String getCSSStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSSStyle();
        }
        return this.cssstyle;
    }

    public boolean isCSSStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSSStyleDirty();
        }
        return this.cssstyleDirtyFlag;
    }

    public void resetCSSStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSSStyle();
            return;
        }
        this.cssstyleDirtyFlag = false;
        this.cssstyle = null;
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

    public void setPSCssCatTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplid = string;
        this.pscsscattemplidDirtyFlag = true;
    }

    public String getPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplId();
        }
        return this.pscsscattemplid;
    }

    public boolean isPSCssCatTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplIdDirty();
        }
        return this.pscsscattemplidDirtyFlag;
    }

    public void resetPSCssCatTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplId();
            return;
        }
        this.pscsscattemplidDirtyFlag = false;
        this.pscsscattemplid = null;
    }

    public void setPSCssCatTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssCatTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsscattemplname = string;
        this.pscsscattemplnameDirtyFlag = true;
    }

    public String getPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTemplName();
        }
        return this.pscsscattemplname;
    }

    public boolean isPSCssCatTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssCatTemplNameDirty();
        }
        return this.pscsscattemplnameDirtyFlag;
    }

    public void resetPSCssCatTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssCatTemplName();
            return;
        }
        this.pscsscattemplnameDirtyFlag = false;
        this.pscsscattemplname = null;
    }

    public void setPSCssTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplid = string;
        this.pscsstemplidDirtyFlag = true;
    }

    public String getPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplId();
        }
        return this.pscsstemplid;
    }

    public boolean isPSCssTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplIdDirty();
        }
        return this.pscsstemplidDirtyFlag;
    }

    public void resetPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplId();
            return;
        }
        this.pscsstemplidDirtyFlag = false;
        this.pscsstemplid = null;
    }

    public void setPSCssTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplname = string;
        this.pscsstemplnameDirtyFlag = true;
    }

    public String getPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplName();
        }
        return this.pscsstemplname;
    }

    public boolean isPSCssTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplNameDirty();
        }
        return this.pscsstemplnameDirtyFlag;
    }

    public void resetPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplName();
            return;
        }
        this.pscsstemplnameDirtyFlag = false;
        this.pscsstemplname = null;
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
        PSCssTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCssTemplBase pSCssTemplBase) {
        pSCssTemplBase.resetCreateDate();
        pSCssTemplBase.resetCreateMan();
        pSCssTemplBase.resetCSSName();
        pSCssTemplBase.resetCSSStyle();
        pSCssTemplBase.resetMemo();
        pSCssTemplBase.resetPSCssCatTemplId();
        pSCssTemplBase.resetPSCssCatTemplName();
        pSCssTemplBase.resetPSCssTemplId();
        pSCssTemplBase.resetPSCssTemplName();
        pSCssTemplBase.resetUpdateDate();
        pSCssTemplBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCSSNameDirty()) {
            hashMap.put(FIELD_CSSNAME, this.getCSSName());
        }
        if (!bl || this.isCSSStyleDirty()) {
            hashMap.put(FIELD_CSSSTYLE, this.getCSSStyle());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCssCatTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLID, this.getPSCssCatTemplId());
        }
        if (!bl || this.isPSCssCatTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSCATTEMPLNAME, this.getPSCssCatTemplName());
        }
        if (!bl || this.isPSCssTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLID, this.getPSCssTemplId());
        }
        if (!bl || this.isPSCssTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLNAME, this.getPSCssTemplName());
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
        return PSCssTemplBase.get(this, n);
    }

    private static Object get(PSCssTemplBase pSCssTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssTemplBase.getCreateDate();
            }
            case 1: {
                return pSCssTemplBase.getCreateMan();
            }
            case 2: {
                return pSCssTemplBase.getCSSName();
            }
            case 3: {
                return pSCssTemplBase.getCSSStyle();
            }
            case 4: {
                return pSCssTemplBase.getMemo();
            }
            case 5: {
                return pSCssTemplBase.getPSCssCatTemplId();
            }
            case 6: {
                return pSCssTemplBase.getPSCssCatTemplName();
            }
            case 7: {
                return pSCssTemplBase.getPSCssTemplId();
            }
            case 8: {
                return pSCssTemplBase.getPSCssTemplName();
            }
            case 9: {
                return pSCssTemplBase.getUpdateDate();
            }
            case 10: {
                return pSCssTemplBase.getUpdateMan();
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
        PSCssTemplBase.set(this, n, object);
    }

    private static void set(PSCssTemplBase pSCssTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCssTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSCssTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCssTemplBase.setCSSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCssTemplBase.setCSSStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCssTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCssTemplBase.setPSCssCatTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCssTemplBase.setPSCssCatTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCssTemplBase.setPSCssTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCssTemplBase.setPSCssTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCssTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSCssTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCssTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSCssTemplBase pSCssTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSCssTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSCssTemplBase.getCSSName() == null;
            }
            case 3: {
                return pSCssTemplBase.getCSSStyle() == null;
            }
            case 4: {
                return pSCssTemplBase.getMemo() == null;
            }
            case 5: {
                return pSCssTemplBase.getPSCssCatTemplId() == null;
            }
            case 6: {
                return pSCssTemplBase.getPSCssCatTemplName() == null;
            }
            case 7: {
                return pSCssTemplBase.getPSCssTemplId() == null;
            }
            case 8: {
                return pSCssTemplBase.getPSCssTemplName() == null;
            }
            case 9: {
                return pSCssTemplBase.getUpdateDate() == null;
            }
            case 10: {
                return pSCssTemplBase.getUpdateMan() == null;
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
        return PSCssTemplBase.contains(this, n);
    }

    private static boolean contains(PSCssTemplBase pSCssTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCssTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSCssTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSCssTemplBase.isCSSNameDirty();
            }
            case 3: {
                return pSCssTemplBase.isCSSStyleDirty();
            }
            case 4: {
                return pSCssTemplBase.isMemoDirty();
            }
            case 5: {
                return pSCssTemplBase.isPSCssCatTemplIdDirty();
            }
            case 6: {
                return pSCssTemplBase.isPSCssCatTemplNameDirty();
            }
            case 7: {
                return pSCssTemplBase.isPSCssTemplIdDirty();
            }
            case 8: {
                return pSCssTemplBase.isPSCssTemplNameDirty();
            }
            case 9: {
                return pSCssTemplBase.isUpdateDateDirty();
            }
            case 10: {
                return pSCssTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCssTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCssTemplBase pSCssTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCssTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getCSSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssname", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getCSSName()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getCSSStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssstyle", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getCSSStyle()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getPSCssCatTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplid", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getPSCssCatTemplId()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getPSCssCatTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsscattemplname", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getPSCssCatTemplName()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getPSCssTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplid", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getPSCssTemplId()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getPSCssTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplname", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getPSCssTemplName()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCssTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCssTemplBase.getJSONValue((Object)pSCssTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCssTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCssTemplBase pSCssTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCssTemplBase.getCreateDate() != null) {
            object = pSCssTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCssTemplBase.getCreateMan() != null) {
            object = pSCssTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getCSSName() != null) {
            object = pSCssTemplBase.getCSSName();
            xmlNode.setAttribute(FIELD_CSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getCSSStyle() != null) {
            object = pSCssTemplBase.getCSSStyle();
            xmlNode.setAttribute(FIELD_CSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getMemo() != null) {
            object = pSCssTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getPSCssCatTemplId() != null) {
            object = pSCssTemplBase.getPSCssCatTemplId();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getPSCssCatTemplName() != null) {
            object = pSCssTemplBase.getPSCssCatTemplName();
            xmlNode.setAttribute(FIELD_PSCSSCATTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getPSCssTemplId() != null) {
            object = pSCssTemplBase.getPSCssTemplId();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getPSCssTemplName() != null) {
            object = pSCssTemplBase.getPSCssTemplName();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCssTemplBase.getUpdateDate() != null) {
            object = pSCssTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCssTemplBase.getUpdateMan() != null) {
            object = pSCssTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCssTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCssTemplBase pSCssTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCssTemplBase.isCreateDateDirty() && (bl || pSCssTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCssTemplBase.getCreateDate());
        }
        if (pSCssTemplBase.isCreateManDirty() && (bl || pSCssTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCssTemplBase.getCreateMan());
        }
        if (pSCssTemplBase.isCSSNameDirty() && (bl || pSCssTemplBase.getCSSName() != null)) {
            iDataObject.set(FIELD_CSSNAME, (Object)pSCssTemplBase.getCSSName());
        }
        if (pSCssTemplBase.isCSSStyleDirty() && (bl || pSCssTemplBase.getCSSStyle() != null)) {
            iDataObject.set(FIELD_CSSSTYLE, (Object)pSCssTemplBase.getCSSStyle());
        }
        if (pSCssTemplBase.isMemoDirty() && (bl || pSCssTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCssTemplBase.getMemo());
        }
        if (pSCssTemplBase.isPSCssCatTemplIdDirty() && (bl || pSCssTemplBase.getPSCssCatTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLID, (Object)pSCssTemplBase.getPSCssCatTemplId());
        }
        if (pSCssTemplBase.isPSCssCatTemplNameDirty() && (bl || pSCssTemplBase.getPSCssCatTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSCATTEMPLNAME, (Object)pSCssTemplBase.getPSCssCatTemplName());
        }
        if (pSCssTemplBase.isPSCssTemplIdDirty() && (bl || pSCssTemplBase.getPSCssTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLID, (Object)pSCssTemplBase.getPSCssTemplId());
        }
        if (pSCssTemplBase.isPSCssTemplNameDirty() && (bl || pSCssTemplBase.getPSCssTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLNAME, (Object)pSCssTemplBase.getPSCssTemplName());
        }
        if (pSCssTemplBase.isUpdateDateDirty() && (bl || pSCssTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCssTemplBase.getUpdateDate());
        }
        if (pSCssTemplBase.isUpdateManDirty() && (bl || pSCssTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCssTemplBase.getUpdateMan());
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
        return PSCssTemplBase.remove(this, n);
    }

    private static boolean remove(PSCssTemplBase pSCssTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCssTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSCssTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSCssTemplBase.resetCSSName();
                return true;
            }
            case 3: {
                pSCssTemplBase.resetCSSStyle();
                return true;
            }
            case 4: {
                pSCssTemplBase.resetMemo();
                return true;
            }
            case 5: {
                pSCssTemplBase.resetPSCssCatTemplId();
                return true;
            }
            case 6: {
                pSCssTemplBase.resetPSCssCatTemplName();
                return true;
            }
            case 7: {
                pSCssTemplBase.resetPSCssTemplId();
                return true;
            }
            case 8: {
                pSCssTemplBase.resetPSCssTemplName();
                return true;
            }
            case 9: {
                pSCssTemplBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSCssTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCssCatTempl getPSCssCatTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssCatTempl();
        }
        if (this.getPSCssCatTemplId() == null) {
            return null;
        }
        Integer n = this.objPSCssCatTemplLock;
        synchronized (n) {
            if (this.pscsscattempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCssCatTemplId(), (Object)this.pscsscattempl.getPSCssCatTemplId()) != 0L) {
                this.pscsscattempl = null;
            }
            if (this.pscsscattempl == null) {
                PSCssCatTempl pSCssCatTempl = new PSCssCatTempl();
                pSCssCatTempl.setPSCssCatTemplId(this.getPSCssCatTemplId());
                PSCssCatTemplService pSCssCatTemplService = (PSCssCatTemplService)ServiceGlobal.getService(PSCssCatTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCssCatTemplService.autoGet((IEntity)pSCssCatTempl);
                this.pscsscattempl = pSCssCatTempl;
            }
            return this.pscsscattempl;
        }
    }

    private PSCssTemplBase getProxyEntity() {
        return this.proxyPSCssTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCssTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSCssTemplBase) {
            this.proxyPSCssTemplBase = (PSCssTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCssTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CSSNAME, 2);
        fieldIndexMap.put(FIELD_CSSSTYLE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLID, 5);
        fieldIndexMap.put(FIELD_PSCSSCATTEMPLNAME, 6);
        fieldIndexMap.put(FIELD_PSCSSTEMPLID, 7);
        fieldIndexMap.put(FIELD_PSCSSTEMPLNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

