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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnModeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnModeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNMODEID = "PSDEPSLNMODEID";
    public static final String FIELD_PSDEPSLNMODENAME = "PSDEPSLNMODENAME";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNID = 3;
    private static final int INDEX_PSDEPSLNMODEID = 4;
    private static final int INDEX_PSDEPSLNMODENAME = 5;
    private static final int INDEX_PSDEPSLNNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnModeBase proxyPSDepSlnModeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnmodeidDirtyFlag = false;
    private boolean psdepslnmodenameDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnmodeid")
    private String psdepslnmodeid;
    @Column(name="psdepslnmodename")
    private String psdepslnmodename;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodeid = string;
        this.psdepslnmodeidDirtyFlag = true;
    }

    public String getPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeId();
        }
        return this.psdepslnmodeid;
    }

    public boolean isPSDepSlnModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeIdDirty();
        }
        return this.psdepslnmodeidDirtyFlag;
    }

    public void resetPSDepSlnModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeId();
            return;
        }
        this.psdepslnmodeidDirtyFlag = false;
        this.psdepslnmodeid = null;
    }

    public void setPSDepSlnModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnmodename = string;
        this.psdepslnmodenameDirtyFlag = true;
    }

    public String getPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnModeName();
        }
        return this.psdepslnmodename;
    }

    public boolean isPSDepSlnModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnModeNameDirty();
        }
        return this.psdepslnmodenameDirtyFlag;
    }

    public void resetPSDepSlnModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnModeName();
            return;
        }
        this.psdepslnmodenameDirtyFlag = false;
        this.psdepslnmodename = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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
        PSDepSlnModeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnModeBase pSDepSlnModeBase) {
        pSDepSlnModeBase.resetCreateDate();
        pSDepSlnModeBase.resetCreateMan();
        pSDepSlnModeBase.resetMemo();
        pSDepSlnModeBase.resetPSDepSlnId();
        pSDepSlnModeBase.resetPSDepSlnModeId();
        pSDepSlnModeBase.resetPSDepSlnModeName();
        pSDepSlnModeBase.resetPSDepSlnName();
        pSDepSlnModeBase.resetUpdateDate();
        pSDepSlnModeBase.resetUpdateMan();
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
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnModeIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODEID, this.getPSDepSlnModeId());
        }
        if (!bl || this.isPSDepSlnModeNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNMODENAME, this.getPSDepSlnModeName());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
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
        return PSDepSlnModeBase.get(this, n);
    }

    private static Object get(PSDepSlnModeBase pSDepSlnModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModeBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnModeBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnModeBase.getMemo();
            }
            case 3: {
                return pSDepSlnModeBase.getPSDepSlnId();
            }
            case 4: {
                return pSDepSlnModeBase.getPSDepSlnModeId();
            }
            case 5: {
                return pSDepSlnModeBase.getPSDepSlnModeName();
            }
            case 6: {
                return pSDepSlnModeBase.getPSDepSlnName();
            }
            case 7: {
                return pSDepSlnModeBase.getUpdateDate();
            }
            case 8: {
                return pSDepSlnModeBase.getUpdateMan();
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
        PSDepSlnModeBase.set(this, n, object);
    }

    private static void set(PSDepSlnModeBase pSDepSlnModeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnModeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnModeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnModeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnModeBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnModeBase.setPSDepSlnModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnModeBase.setPSDepSlnModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnModeBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnModeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnModeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnModeBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnModeBase pSDepSlnModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnModeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnModeBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnModeBase.getPSDepSlnId() == null;
            }
            case 4: {
                return pSDepSlnModeBase.getPSDepSlnModeId() == null;
            }
            case 5: {
                return pSDepSlnModeBase.getPSDepSlnModeName() == null;
            }
            case 6: {
                return pSDepSlnModeBase.getPSDepSlnName() == null;
            }
            case 7: {
                return pSDepSlnModeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDepSlnModeBase.getUpdateMan() == null;
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
        return PSDepSlnModeBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnModeBase pSDepSlnModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnModeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnModeBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnModeBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnModeBase.isPSDepSlnIdDirty();
            }
            case 4: {
                return pSDepSlnModeBase.isPSDepSlnModeIdDirty();
            }
            case 5: {
                return pSDepSlnModeBase.isPSDepSlnModeNameDirty();
            }
            case 6: {
                return pSDepSlnModeBase.isPSDepSlnNameDirty();
            }
            case 7: {
                return pSDepSlnModeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDepSlnModeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnModeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnModeBase pSDepSlnModeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnModeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodeid", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getPSDepSlnModeId()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnmodename", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getPSDepSlnModeName()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnModeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnModeBase.getJSONValue((Object)pSDepSlnModeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnModeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnModeBase pSDepSlnModeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnModeBase.getCreateDate() != null) {
            object = pSDepSlnModeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnModeBase.getCreateMan() != null) {
            object = pSDepSlnModeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getMemo() != null) {
            object = pSDepSlnModeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnId() != null) {
            object = pSDepSlnModeBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnModeId() != null) {
            object = pSDepSlnModeBase.getPSDepSlnModeId();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnModeName() != null) {
            object = pSDepSlnModeBase.getPSDepSlnModeName();
            xmlNode.setAttribute(FIELD_PSDEPSLNMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getPSDepSlnName() != null) {
            object = pSDepSlnModeBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnModeBase.getUpdateDate() != null) {
            object = pSDepSlnModeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnModeBase.getUpdateMan() != null) {
            object = pSDepSlnModeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnModeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnModeBase pSDepSlnModeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnModeBase.isCreateDateDirty() && (bl || pSDepSlnModeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnModeBase.getCreateDate());
        }
        if (pSDepSlnModeBase.isCreateManDirty() && (bl || pSDepSlnModeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnModeBase.getCreateMan());
        }
        if (pSDepSlnModeBase.isMemoDirty() && (bl || pSDepSlnModeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnModeBase.getMemo());
        }
        if (pSDepSlnModeBase.isPSDepSlnIdDirty() && (bl || pSDepSlnModeBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnModeBase.getPSDepSlnId());
        }
        if (pSDepSlnModeBase.isPSDepSlnModeIdDirty() && (bl || pSDepSlnModeBase.getPSDepSlnModeId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODEID, (Object)pSDepSlnModeBase.getPSDepSlnModeId());
        }
        if (pSDepSlnModeBase.isPSDepSlnModeNameDirty() && (bl || pSDepSlnModeBase.getPSDepSlnModeName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNMODENAME, (Object)pSDepSlnModeBase.getPSDepSlnModeName());
        }
        if (pSDepSlnModeBase.isPSDepSlnNameDirty() && (bl || pSDepSlnModeBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnModeBase.getPSDepSlnName());
        }
        if (pSDepSlnModeBase.isUpdateDateDirty() && (bl || pSDepSlnModeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnModeBase.getUpdateDate());
        }
        if (pSDepSlnModeBase.isUpdateManDirty() && (bl || pSDepSlnModeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnModeBase.getUpdateMan());
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
        return PSDepSlnModeBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnModeBase pSDepSlnModeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnModeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnModeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnModeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnModeBase.resetPSDepSlnId();
                return true;
            }
            case 4: {
                pSDepSlnModeBase.resetPSDepSlnModeId();
                return true;
            }
            case 5: {
                pSDepSlnModeBase.resetPSDepSlnModeName();
                return true;
            }
            case 6: {
                pSDepSlnModeBase.resetPSDepSlnName();
                return true;
            }
            case 7: {
                pSDepSlnModeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDepSlnModeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnModeBase getProxyEntity() {
        return this.proxyPSDepSlnModeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnModeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnModeBase) {
            this.proxyPSDepSlnModeBase = (PSDepSlnModeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnModeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNMODEID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNMODENAME, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

