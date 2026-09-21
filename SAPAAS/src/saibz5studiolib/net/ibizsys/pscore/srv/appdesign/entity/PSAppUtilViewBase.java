/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppUtilViewBase
extends PSAppView {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUtilViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ERRCODE = "ERRCODE";
    public static final String FIELD_PSAPPMENUID = "PSAPPMENUID";
    public static final String FIELD_PSAPPMENUNAME = "PSAPPMENUNAME";
    public static final String FIELD_PSAPPUTILVIEWID = "PSAPPUTILVIEWID";
    public static final String FIELD_PSAPPUTILVIEWNAME = "PSAPPUTILVIEWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_ERRCODE = 12;
    private static final int INDEX_PSAPPMENUID = 21;
    private static final int INDEX_PSAPPMENUNAME = 22;
    private static final int INDEX_PSAPPUTILVIEWID = 27;
    private static final int INDEX_PSAPPUTILVIEWNAME = 28;
    private static final int INDEX_UPDATEDATE = 81;
    private static final int INDEX_UPDATEMAN = 82;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUtilViewBase proxyPSAppUtilViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean errcodeDirtyFlag = false;
    private boolean psappmenuidDirtyFlag = false;
    private boolean psappmenunameDirtyFlag = false;
    private boolean psapputilviewidDirtyFlag = false;
    private boolean psapputilviewnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="errcode")
    private String errcode;
    @Column(name="psappmenuid")
    private String psappmenuid;
    @Column(name="psappmenuname")
    private String psappmenuname;
    @Column(name="psapputilviewid")
    private String psapputilviewid;
    @Column(name="psapputilviewname")
    private String psapputilviewname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSAppMenuLock = new Integer(1);
    private PSAppMenu psappmenu = null;

    public PSAppUtilViewBase() {
        try {
            this.set("PSAPPVIEWTYPE", "APPUTILVIEW");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
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

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    public void setErrCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errcode = string;
        this.errcodeDirtyFlag = true;
    }

    public String getErrCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrCode();
        }
        return this.errcode;
    }

    public boolean isErrCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrCodeDirty();
        }
        return this.errcodeDirtyFlag;
    }

    public void resetErrCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrCode();
            return;
        }
        this.errcodeDirtyFlag = false;
        this.errcode = null;
    }

    public void setPSAppMenuId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuid = string;
        this.psappmenuidDirtyFlag = true;
    }

    public String getPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuId();
        }
        return this.psappmenuid;
    }

    public boolean isPSAppMenuIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuIdDirty();
        }
        return this.psappmenuidDirtyFlag;
    }

    public void resetPSAppMenuId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuId();
            return;
        }
        this.psappmenuidDirtyFlag = false;
        this.psappmenuid = null;
    }

    public void setPSAppMenuName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppMenuName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmenuname = string;
        this.psappmenunameDirtyFlag = true;
    }

    public String getPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenuName();
        }
        return this.psappmenuname;
    }

    public boolean isPSAppMenuNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppMenuNameDirty();
        }
        return this.psappmenunameDirtyFlag;
    }

    public void resetPSAppMenuName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppMenuName();
            return;
        }
        this.psappmenunameDirtyFlag = false;
        this.psappmenuname = null;
    }

    public void setPSAppUtilViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilviewid = string;
        this.psapputilviewidDirtyFlag = true;
        super.setPSAppViewId(string);
    }

    public String getPSAppUtilViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilViewId();
        }
        return this.psapputilviewid;
    }

    public boolean isPSAppUtilViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilViewIdDirty();
        }
        return this.psapputilviewidDirtyFlag;
    }

    public void resetPSAppUtilViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilViewId();
            return;
        }
        this.psapputilviewidDirtyFlag = false;
        this.psapputilviewid = null;
        super.resetPSAppViewId();
    }

    public void setPSAppUtilViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputilviewname = string;
        this.psapputilviewnameDirtyFlag = true;
        super.setPSAppViewName(string);
    }

    public String getPSAppUtilViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilViewName();
        }
        return this.psapputilviewname;
    }

    public boolean isPSAppUtilViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilViewNameDirty();
        }
        return this.psapputilviewnameDirtyFlag;
    }

    public void resetPSAppUtilViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilViewName();
            return;
        }
        this.psapputilviewnameDirtyFlag = false;
        this.psapputilviewname = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
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

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    @Override
    protected void onReset() {
        PSAppUtilViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUtilViewBase pSAppUtilViewBase) {
        pSAppUtilViewBase.resetCreateDate();
        pSAppUtilViewBase.resetCreateMan();
        pSAppUtilViewBase.resetErrCode();
        pSAppUtilViewBase.resetPSAppMenuId();
        pSAppUtilViewBase.resetPSAppMenuName();
        pSAppUtilViewBase.resetPSAppUtilViewId();
        pSAppUtilViewBase.resetPSAppUtilViewName();
        pSAppUtilViewBase.resetUpdateDate();
        pSAppUtilViewBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isErrCodeDirty()) {
            hashMap.put(FIELD_ERRCODE, this.getErrCode());
        }
        if (!bl || this.isPSAppMenuIdDirty()) {
            hashMap.put(FIELD_PSAPPMENUID, this.getPSAppMenuId());
        }
        if (!bl || this.isPSAppMenuNameDirty()) {
            hashMap.put(FIELD_PSAPPMENUNAME, this.getPSAppMenuName());
        }
        if (!bl || this.isPSAppUtilViewIdDirty()) {
            hashMap.put(FIELD_PSAPPUTILVIEWID, this.getPSAppUtilViewId());
        }
        if (!bl || this.isPSAppUtilViewNameDirty()) {
            hashMap.put(FIELD_PSAPPUTILVIEWNAME, this.getPSAppUtilViewName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
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
        return PSAppUtilViewBase.get(this, n);
    }

    private static Object get(PSAppUtilViewBase pSAppUtilViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppUtilViewBase.getCreateDate();
            }
            case 8: {
                return pSAppUtilViewBase.getCreateMan();
            }
            case 12: {
                return pSAppUtilViewBase.getErrCode();
            }
            case 21: {
                return pSAppUtilViewBase.getPSAppMenuId();
            }
            case 22: {
                return pSAppUtilViewBase.getPSAppMenuName();
            }
            case 27: {
                return pSAppUtilViewBase.getPSAppUtilViewId();
            }
            case 28: {
                return pSAppUtilViewBase.getPSAppUtilViewName();
            }
            case 81: {
                return pSAppUtilViewBase.getUpdateDate();
            }
            case 82: {
                return pSAppUtilViewBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        PSAppUtilViewBase.set(this, n, object);
    }

    private static void set(PSAppUtilViewBase pSAppUtilViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 7: {
                pSAppUtilViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppUtilViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUtilViewBase.setErrCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSAppUtilViewBase.setPSAppMenuId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSAppUtilViewBase.setPSAppMenuName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSAppUtilViewBase.setPSAppUtilViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSAppUtilViewBase.setPSAppUtilViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 81: {
                pSAppUtilViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 82: {
                pSAppUtilViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSAppUtilViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUtilViewBase pSAppUtilViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppUtilViewBase.getCreateDate() == null;
            }
            case 8: {
                return pSAppUtilViewBase.getCreateMan() == null;
            }
            case 12: {
                return pSAppUtilViewBase.getErrCode() == null;
            }
            case 21: {
                return pSAppUtilViewBase.getPSAppMenuId() == null;
            }
            case 22: {
                return pSAppUtilViewBase.getPSAppMenuName() == null;
            }
            case 27: {
                return pSAppUtilViewBase.getPSAppUtilViewId() == null;
            }
            case 28: {
                return pSAppUtilViewBase.getPSAppUtilViewName() == null;
            }
            case 81: {
                return pSAppUtilViewBase.getUpdateDate() == null;
            }
            case 82: {
                return pSAppUtilViewBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSAppUtilViewBase.contains(this, n);
    }

    private static boolean contains(PSAppUtilViewBase pSAppUtilViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                return pSAppUtilViewBase.isCreateDateDirty();
            }
            case 8: {
                return pSAppUtilViewBase.isCreateManDirty();
            }
            case 12: {
                return pSAppUtilViewBase.isErrCodeDirty();
            }
            case 21: {
                return pSAppUtilViewBase.isPSAppMenuIdDirty();
            }
            case 22: {
                return pSAppUtilViewBase.isPSAppMenuNameDirty();
            }
            case 27: {
                return pSAppUtilViewBase.isPSAppUtilViewIdDirty();
            }
            case 28: {
                return pSAppUtilViewBase.isPSAppUtilViewNameDirty();
            }
            case 81: {
                return pSAppUtilViewBase.isUpdateDateDirty();
            }
            case 82: {
                return pSAppUtilViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUtilViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUtilViewBase pSAppUtilViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUtilViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getErrCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errcode", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getErrCode()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getPSAppMenuId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuid", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getPSAppMenuId()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getPSAppMenuName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmenuname", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getPSAppMenuName()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getPSAppUtilViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilviewid", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getPSAppUtilViewId()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getPSAppUtilViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputilviewname", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getPSAppUtilViewName()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUtilViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUtilViewBase.getJSONValue((Object)pSAppUtilViewBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUtilViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUtilViewBase pSAppUtilViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUtilViewBase.getCreateDate() != null) {
            object = pSAppUtilViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilViewBase.getCreateMan() != null) {
            object = pSAppUtilViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getErrCode() != null) {
            object = pSAppUtilViewBase.getErrCode();
            xmlNode.setAttribute(FIELD_ERRCODE, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getPSAppMenuId() != null) {
            object = pSAppUtilViewBase.getPSAppMenuId();
            xmlNode.setAttribute(FIELD_PSAPPMENUID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getPSAppMenuName() != null) {
            object = pSAppUtilViewBase.getPSAppMenuName();
            xmlNode.setAttribute(FIELD_PSAPPMENUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getPSAppUtilViewId() != null) {
            object = pSAppUtilViewBase.getPSAppUtilViewId();
            xmlNode.setAttribute(FIELD_PSAPPUTILVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getPSAppUtilViewName() != null) {
            object = pSAppUtilViewBase.getPSAppUtilViewName();
            xmlNode.setAttribute(FIELD_PSAPPUTILVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilViewBase.getUpdateDate() != null) {
            object = pSAppUtilViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilViewBase.getUpdateMan() != null) {
            object = pSAppUtilViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUtilViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUtilViewBase pSAppUtilViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUtilViewBase.isCreateDateDirty() && (bl || pSAppUtilViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUtilViewBase.getCreateDate());
        }
        if (pSAppUtilViewBase.isCreateManDirty() && (bl || pSAppUtilViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUtilViewBase.getCreateMan());
        }
        if (pSAppUtilViewBase.isErrCodeDirty() && (bl || pSAppUtilViewBase.getErrCode() != null)) {
            iDataObject.set(FIELD_ERRCODE, (Object)pSAppUtilViewBase.getErrCode());
        }
        if (pSAppUtilViewBase.isPSAppMenuIdDirty() && (bl || pSAppUtilViewBase.getPSAppMenuId() != null)) {
            iDataObject.set(FIELD_PSAPPMENUID, (Object)pSAppUtilViewBase.getPSAppMenuId());
        }
        if (pSAppUtilViewBase.isPSAppMenuNameDirty() && (bl || pSAppUtilViewBase.getPSAppMenuName() != null)) {
            iDataObject.set(FIELD_PSAPPMENUNAME, (Object)pSAppUtilViewBase.getPSAppMenuName());
        }
        if (pSAppUtilViewBase.isPSAppUtilViewIdDirty() && (bl || pSAppUtilViewBase.getPSAppUtilViewId() != null)) {
            iDataObject.set(FIELD_PSAPPUTILVIEWID, (Object)pSAppUtilViewBase.getPSAppUtilViewId());
        }
        if (pSAppUtilViewBase.isPSAppUtilViewNameDirty() && (bl || pSAppUtilViewBase.getPSAppUtilViewName() != null)) {
            iDataObject.set(FIELD_PSAPPUTILVIEWNAME, (Object)pSAppUtilViewBase.getPSAppUtilViewName());
        }
        if (pSAppUtilViewBase.isUpdateDateDirty() && (bl || pSAppUtilViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUtilViewBase.getUpdateDate());
        }
        if (pSAppUtilViewBase.isUpdateManDirty() && (bl || pSAppUtilViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUtilViewBase.getUpdateMan());
        }
    }

    @Override
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
        return PSAppUtilViewBase.remove(this, n);
    }

    private static boolean remove(PSAppUtilViewBase pSAppUtilViewBase, int n) throws Exception {
        switch (n) {
            case 7: {
                pSAppUtilViewBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSAppUtilViewBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSAppUtilViewBase.resetErrCode();
                return true;
            }
            case 21: {
                pSAppUtilViewBase.resetPSAppMenuId();
                return true;
            }
            case 22: {
                pSAppUtilViewBase.resetPSAppMenuName();
                return true;
            }
            case 27: {
                pSAppUtilViewBase.resetPSAppUtilViewId();
                return true;
            }
            case 28: {
                pSAppUtilViewBase.resetPSAppUtilViewName();
                return true;
            }
            case 81: {
                pSAppUtilViewBase.resetUpdateDate();
                return true;
            }
            case 82: {
                pSAppUtilViewBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppMenu getPSAppMenu() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppMenu();
        }
        if (this.getPSAppMenuId() == null) {
            return null;
        }
        Integer n = this.objPSAppMenuLock;
        synchronized (n) {
            if (this.psappmenu != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppMenuId(), (Object)this.psappmenu.getPSAppMenuId()) != 0L) {
                this.psappmenu = null;
            }
            if (this.psappmenu == null) {
                PSAppMenu pSAppMenu = new PSAppMenu();
                pSAppMenu.setPSAppMenuId(this.getPSAppMenuId());
                PSAppMenuService pSAppMenuService = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
                pSAppMenuService.autoGet((IEntity)pSAppMenu);
                this.psappmenu = pSAppMenu;
            }
            return this.psappmenu;
        }
    }

    private PSAppUtilViewBase getProxyEntity() {
        return this.proxyPSAppUtilViewBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUtilViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUtilViewBase) {
            this.proxyPSAppUtilViewBase = (PSAppUtilViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppUtilViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_ERRCODE, 12);
        fieldIndexMap.put(FIELD_PSAPPMENUID, 21);
        fieldIndexMap.put(FIELD_PSAPPMENUNAME, 22);
        fieldIndexMap.put(FIELD_PSAPPUTILVIEWID, 27);
        fieldIndexMap.put(FIELD_PSAPPUTILVIEWNAME, 28);
        fieldIndexMap.put(FIELD_UPDATEDATE, 81);
        fieldIndexMap.put(FIELD_UPDATEMAN, 82);
    }
}

