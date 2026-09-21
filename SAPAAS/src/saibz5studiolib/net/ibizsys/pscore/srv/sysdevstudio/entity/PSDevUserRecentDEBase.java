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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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

public abstract class PSDevUserRecentDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserRecentDEBase.class);
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_OBJID = "OBJID";
    public static final String FIELD_OBJTYPE = "OBJTYPE";
    public static final String FIELD_PSDATAENTITYNAME = "PSDATAENTITYNAME";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERRECENTID = "PSDEVUSERRECENTID";
    public static final String FIELD_PSDEVUSERRECENTNAME = "PSDEVUSERRECENTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    private static final int INDEX_LOGICNAME = 0;
    private static final int INDEX_OBJID = 1;
    private static final int INDEX_OBJTYPE = 2;
    private static final int INDEX_PSDATAENTITYNAME = 3;
    private static final int INDEX_PSDEVUSERID = 4;
    private static final int INDEX_PSDEVUSERRECENTID = 5;
    private static final int INDEX_PSDEVUSERRECENTNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserRecentDEBase proxyPSDevUserRecentDEBase = null;
    private boolean logicnameDirtyFlag = false;
    private boolean objidDirtyFlag = false;
    private boolean objtypeDirtyFlag = false;
    private boolean psdataentitynameDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevuserrecentidDirtyFlag = false;
    private boolean psdevuserrecentnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    @Column(name="logicname")
    private String logicname;
    @Column(name="objid")
    private String objid;
    @Column(name="objtype")
    private String objtype;
    @Column(name="psdataentityname")
    private String psdataentityname;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevuserrecentid")
    private String psdevuserrecentid;
    @Column(name="psdevuserrecentname")
    private String psdevuserrecentname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objid = string;
        this.objidDirtyFlag = true;
    }

    public String getObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjId();
        }
        return this.objid;
    }

    public boolean isObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjIdDirty();
        }
        return this.objidDirtyFlag;
    }

    public void resetObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjId();
            return;
        }
        this.objidDirtyFlag = false;
        this.objid = null;
    }

    public void setObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.objtype = string;
        this.objtypeDirtyFlag = true;
    }

    public String getObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getObjType();
        }
        return this.objtype;
    }

    public boolean isObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isObjTypeDirty();
        }
        return this.objtypeDirtyFlag;
    }

    public void resetObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetObjType();
            return;
        }
        this.objtypeDirtyFlag = false;
        this.objtype = null;
    }

    public void setPSDataEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDataEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdataentityname = string;
        this.psdataentitynameDirtyFlag = true;
    }

    public String getPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDataEntityName();
        }
        return this.psdataentityname;
    }

    public boolean isPSDataEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDataEntityNameDirty();
        }
        return this.psdataentitynameDirtyFlag;
    }

    public void resetPSDataEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDataEntityName();
            return;
        }
        this.psdataentitynameDirtyFlag = false;
        this.psdataentityname = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserRecentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserRecentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserrecentid = string;
        this.psdevuserrecentidDirtyFlag = true;
    }

    public String getPSDevUserRecentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserRecentId();
        }
        return this.psdevuserrecentid;
    }

    public boolean isPSDevUserRecentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserRecentIdDirty();
        }
        return this.psdevuserrecentidDirtyFlag;
    }

    public void resetPSDevUserRecentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserRecentId();
            return;
        }
        this.psdevuserrecentidDirtyFlag = false;
        this.psdevuserrecentid = null;
    }

    public void setPSDevUserRecentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserRecentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserrecentname = string;
        this.psdevuserrecentnameDirtyFlag = true;
    }

    public String getPSDevUserRecentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserRecentName();
        }
        return this.psdevuserrecentname;
    }

    public boolean isPSDevUserRecentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserRecentNameDirty();
        }
        return this.psdevuserrecentnameDirtyFlag;
    }

    public void resetPSDevUserRecentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserRecentName();
            return;
        }
        this.psdevuserrecentnameDirtyFlag = false;
        this.psdevuserrecentname = null;
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

    protected void onReset() {
        PSDevUserRecentDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserRecentDEBase pSDevUserRecentDEBase) {
        pSDevUserRecentDEBase.resetLogicName();
        pSDevUserRecentDEBase.resetObjId();
        pSDevUserRecentDEBase.resetObjType();
        pSDevUserRecentDEBase.resetPSDataEntityName();
        pSDevUserRecentDEBase.resetPSDevUserId();
        pSDevUserRecentDEBase.resetPSDevUserRecentId();
        pSDevUserRecentDEBase.resetPSDevUserRecentName();
        pSDevUserRecentDEBase.resetUpdateDate();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isObjIdDirty()) {
            hashMap.put(FIELD_OBJID, this.getObjId());
        }
        if (!bl || this.isObjTypeDirty()) {
            hashMap.put(FIELD_OBJTYPE, this.getObjType());
        }
        if (!bl || this.isPSDataEntityNameDirty()) {
            hashMap.put(FIELD_PSDATAENTITYNAME, this.getPSDataEntityName());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserRecentIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERRECENTID, this.getPSDevUserRecentId());
        }
        if (!bl || this.isPSDevUserRecentNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERRECENTNAME, this.getPSDevUserRecentName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
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
        return PSDevUserRecentDEBase.get(this, n);
    }

    private static Object get(PSDevUserRecentDEBase pSDevUserRecentDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentDEBase.getLogicName();
            }
            case 1: {
                return pSDevUserRecentDEBase.getObjId();
            }
            case 2: {
                return pSDevUserRecentDEBase.getObjType();
            }
            case 3: {
                return pSDevUserRecentDEBase.getPSDataEntityName();
            }
            case 4: {
                return pSDevUserRecentDEBase.getPSDevUserId();
            }
            case 5: {
                return pSDevUserRecentDEBase.getPSDevUserRecentId();
            }
            case 6: {
                return pSDevUserRecentDEBase.getPSDevUserRecentName();
            }
            case 7: {
                return pSDevUserRecentDEBase.getUpdateDate();
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
        PSDevUserRecentDEBase.set(this, n, object);
    }

    private static void set(PSDevUserRecentDEBase pSDevUserRecentDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserRecentDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserRecentDEBase.setObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserRecentDEBase.setObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserRecentDEBase.setPSDataEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserRecentDEBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserRecentDEBase.setPSDevUserRecentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserRecentDEBase.setPSDevUserRecentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserRecentDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
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
        return PSDevUserRecentDEBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserRecentDEBase pSDevUserRecentDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentDEBase.getLogicName() == null;
            }
            case 1: {
                return pSDevUserRecentDEBase.getObjId() == null;
            }
            case 2: {
                return pSDevUserRecentDEBase.getObjType() == null;
            }
            case 3: {
                return pSDevUserRecentDEBase.getPSDataEntityName() == null;
            }
            case 4: {
                return pSDevUserRecentDEBase.getPSDevUserId() == null;
            }
            case 5: {
                return pSDevUserRecentDEBase.getPSDevUserRecentId() == null;
            }
            case 6: {
                return pSDevUserRecentDEBase.getPSDevUserRecentName() == null;
            }
            case 7: {
                return pSDevUserRecentDEBase.getUpdateDate() == null;
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
        return PSDevUserRecentDEBase.contains(this, n);
    }

    private static boolean contains(PSDevUserRecentDEBase pSDevUserRecentDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserRecentDEBase.isLogicNameDirty();
            }
            case 1: {
                return pSDevUserRecentDEBase.isObjIdDirty();
            }
            case 2: {
                return pSDevUserRecentDEBase.isObjTypeDirty();
            }
            case 3: {
                return pSDevUserRecentDEBase.isPSDataEntityNameDirty();
            }
            case 4: {
                return pSDevUserRecentDEBase.isPSDevUserIdDirty();
            }
            case 5: {
                return pSDevUserRecentDEBase.isPSDevUserRecentIdDirty();
            }
            case 6: {
                return pSDevUserRecentDEBase.isPSDevUserRecentNameDirty();
            }
            case 7: {
                return pSDevUserRecentDEBase.isUpdateDateDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserRecentDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserRecentDEBase pSDevUserRecentDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserRecentDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objid", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getObjId()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"objtype", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getObjType()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getPSDataEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdataentityname", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getPSDataEntityName()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserRecentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserrecentid", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getPSDevUserRecentId()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserRecentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserrecentname", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getPSDevUserRecentName()), (boolean)false);
        }
        if (bl || pSDevUserRecentDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserRecentDEBase.getJSONValue((Object)pSDevUserRecentDEBase.getUpdateDate()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserRecentDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserRecentDEBase pSDevUserRecentDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserRecentDEBase.getLogicName() != null) {
            object = pSDevUserRecentDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getObjId() != null) {
            object = pSDevUserRecentDEBase.getObjId();
            xmlNode.setAttribute(FIELD_OBJID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getObjType() != null) {
            object = pSDevUserRecentDEBase.getObjType();
            xmlNode.setAttribute(FIELD_OBJTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getPSDataEntityName() != null) {
            object = pSDevUserRecentDEBase.getPSDataEntityName();
            xmlNode.setAttribute(FIELD_PSDATAENTITYNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserId() != null) {
            object = pSDevUserRecentDEBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserRecentId() != null) {
            object = pSDevUserRecentDEBase.getPSDevUserRecentId();
            xmlNode.setAttribute(FIELD_PSDEVUSERRECENTID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevUserRecentDEBase.getPSDevUserRecentName() != null) {
            object = pSDevUserRecentDEBase.getPSDevUserRecentName();
            xmlNode.setAttribute(FIELD_PSDEVUSERRECENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserRecentDEBase.getUpdateDate() != null) {
            object = pSDevUserRecentDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserRecentDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserRecentDEBase pSDevUserRecentDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserRecentDEBase.isLogicNameDirty() && (bl || pSDevUserRecentDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevUserRecentDEBase.getLogicName());
        }
        if (pSDevUserRecentDEBase.isObjIdDirty() && (bl || pSDevUserRecentDEBase.getObjId() != null)) {
            iDataObject.set(FIELD_OBJID, (Object)pSDevUserRecentDEBase.getObjId());
        }
        if (pSDevUserRecentDEBase.isObjTypeDirty() && (bl || pSDevUserRecentDEBase.getObjType() != null)) {
            iDataObject.set(FIELD_OBJTYPE, (Object)pSDevUserRecentDEBase.getObjType());
        }
        if (pSDevUserRecentDEBase.isPSDataEntityNameDirty() && (bl || pSDevUserRecentDEBase.getPSDataEntityName() != null)) {
            iDataObject.set(FIELD_PSDATAENTITYNAME, (Object)pSDevUserRecentDEBase.getPSDataEntityName());
        }
        if (pSDevUserRecentDEBase.isPSDevUserIdDirty() && (bl || pSDevUserRecentDEBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevUserRecentDEBase.getPSDevUserId());
        }
        if (pSDevUserRecentDEBase.isPSDevUserRecentIdDirty() && (bl || pSDevUserRecentDEBase.getPSDevUserRecentId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERRECENTID, (Object)pSDevUserRecentDEBase.getPSDevUserRecentId());
        }
        if (pSDevUserRecentDEBase.isPSDevUserRecentNameDirty() && (bl || pSDevUserRecentDEBase.getPSDevUserRecentName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERRECENTNAME, (Object)pSDevUserRecentDEBase.getPSDevUserRecentName());
        }
        if (pSDevUserRecentDEBase.isUpdateDateDirty() && (bl || pSDevUserRecentDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserRecentDEBase.getUpdateDate());
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
        return PSDevUserRecentDEBase.remove(this, n);
    }

    private static boolean remove(PSDevUserRecentDEBase pSDevUserRecentDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserRecentDEBase.resetLogicName();
                return true;
            }
            case 1: {
                pSDevUserRecentDEBase.resetObjId();
                return true;
            }
            case 2: {
                pSDevUserRecentDEBase.resetObjType();
                return true;
            }
            case 3: {
                pSDevUserRecentDEBase.resetPSDataEntityName();
                return true;
            }
            case 4: {
                pSDevUserRecentDEBase.resetPSDevUserId();
                return true;
            }
            case 5: {
                pSDevUserRecentDEBase.resetPSDevUserRecentId();
                return true;
            }
            case 6: {
                pSDevUserRecentDEBase.resetPSDevUserRecentName();
                return true;
            }
            case 7: {
                pSDevUserRecentDEBase.resetUpdateDate();
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
        if (this.getObjId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getObjId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getObjId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSDevUserRecentDEBase getProxyEntity() {
        return this.proxyPSDevUserRecentDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserRecentDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserRecentDEBase) {
            this.proxyPSDevUserRecentDEBase = (PSDevUserRecentDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevUserRecentDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_LOGICNAME, 0);
        fieldIndexMap.put(FIELD_OBJID, 1);
        fieldIndexMap.put(FIELD_OBJTYPE, 2);
        fieldIndexMap.put(FIELD_PSDATAENTITYNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 4);
        fieldIndexMap.put(FIELD_PSDEVUSERRECENTID, 5);
        fieldIndexMap.put(FIELD_PSDEVUSERRECENTNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
    }
}

