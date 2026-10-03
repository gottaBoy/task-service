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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMTDECatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMTDECatBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCMODELTEMPLID = "PSDCMODELTEMPLID";
    public static final String FIELD_PSDCMODELTEMPLNAME = "PSDCMODELTEMPLNAME";
    public static final String FIELD_PSDCMTDECATID = "PSDCMTDECATID";
    public static final String FIELD_PSDCMTDECATNAME = "PSDCMTDECATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCMODELTEMPLID = 2;
    private static final int INDEX_PSDCMODELTEMPLNAME = 3;
    private static final int INDEX_PSDCMTDECATID = 4;
    private static final int INDEX_PSDCMTDECATNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMTDECatBase proxyPSDCMTDECatBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcmodeltemplidDirtyFlag = false;
    private boolean psdcmodeltemplnameDirtyFlag = false;
    private boolean psdcmtdecatidDirtyFlag = false;
    private boolean psdcmtdecatnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcmodeltemplid")
    private String psdcmodeltemplid;
    @Column(name="psdcmodeltemplname")
    private String psdcmodeltemplname;
    @Column(name="psdcmtdecatid")
    private String psdcmtdecatid;
    @Column(name="psdcmtdecatname")
    private String psdcmtdecatname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCModelTemplLock = new Integer(1);
    private PSDCModelTempl psdcmodeltempl = null;

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

    public void setPSDCModelTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplid = string;
        this.psdcmodeltemplidDirtyFlag = true;
    }

    public String getPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplId();
        }
        return this.psdcmodeltemplid;
    }

    public boolean isPSDCModelTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplIdDirty();
        }
        return this.psdcmodeltemplidDirtyFlag;
    }

    public void resetPSDCModelTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplId();
            return;
        }
        this.psdcmodeltemplidDirtyFlag = false;
        this.psdcmodeltemplid = null;
    }

    public void setPSDCModelTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCModelTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmodeltemplname = string;
        this.psdcmodeltemplnameDirtyFlag = true;
    }

    public String getPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTemplName();
        }
        return this.psdcmodeltemplname;
    }

    public boolean isPSDCModelTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCModelTemplNameDirty();
        }
        return this.psdcmodeltemplnameDirtyFlag;
    }

    public void resetPSDCModelTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCModelTemplName();
            return;
        }
        this.psdcmodeltemplnameDirtyFlag = false;
        this.psdcmodeltemplname = null;
    }

    public void setPSDCMTDECatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMTDECatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmtdecatid = string;
        this.psdcmtdecatidDirtyFlag = true;
    }

    public String getPSDCMTDECatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDECatId();
        }
        return this.psdcmtdecatid;
    }

    public boolean isPSDCMTDECatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMTDECatIdDirty();
        }
        return this.psdcmtdecatidDirtyFlag;
    }

    public void resetPSDCMTDECatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMTDECatId();
            return;
        }
        this.psdcmtdecatidDirtyFlag = false;
        this.psdcmtdecatid = null;
    }

    public void setPSDCMTDECatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMTDECatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmtdecatname = string;
        this.psdcmtdecatnameDirtyFlag = true;
    }

    public String getPSDCMTDECatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMTDECatName();
        }
        return this.psdcmtdecatname;
    }

    public boolean isPSDCMTDECatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMTDECatNameDirty();
        }
        return this.psdcmtdecatnameDirtyFlag;
    }

    public void resetPSDCMTDECatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMTDECatName();
            return;
        }
        this.psdcmtdecatnameDirtyFlag = false;
        this.psdcmtdecatname = null;
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
        PSDCMTDECatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMTDECatBase pSDCMTDECatBase) {
        pSDCMTDECatBase.resetCreateDate();
        pSDCMTDECatBase.resetCreateMan();
        pSDCMTDECatBase.resetPSDCModelTemplId();
        pSDCMTDECatBase.resetPSDCModelTemplName();
        pSDCMTDECatBase.resetPSDCMTDECatId();
        pSDCMTDECatBase.resetPSDCMTDECatName();
        pSDCMTDECatBase.resetUpdateDate();
        pSDCMTDECatBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCModelTemplIdDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLID, this.getPSDCModelTemplId());
        }
        if (!bl || this.isPSDCModelTemplNameDirty()) {
            hashMap.put(FIELD_PSDCMODELTEMPLNAME, this.getPSDCModelTemplName());
        }
        if (!bl || this.isPSDCMTDECatIdDirty()) {
            hashMap.put(FIELD_PSDCMTDECATID, this.getPSDCMTDECatId());
        }
        if (!bl || this.isPSDCMTDECatNameDirty()) {
            hashMap.put(FIELD_PSDCMTDECATNAME, this.getPSDCMTDECatName());
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
        return PSDCMTDECatBase.get(this, n);
    }

    private static Object get(PSDCMTDECatBase pSDCMTDECatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDECatBase.getCreateDate();
            }
            case 1: {
                return pSDCMTDECatBase.getCreateMan();
            }
            case 2: {
                return pSDCMTDECatBase.getPSDCModelTemplId();
            }
            case 3: {
                return pSDCMTDECatBase.getPSDCModelTemplName();
            }
            case 4: {
                return pSDCMTDECatBase.getPSDCMTDECatId();
            }
            case 5: {
                return pSDCMTDECatBase.getPSDCMTDECatName();
            }
            case 6: {
                return pSDCMTDECatBase.getUpdateDate();
            }
            case 7: {
                return pSDCMTDECatBase.getUpdateMan();
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
        PSDCMTDECatBase.set(this, n, object);
    }

    private static void set(PSDCMTDECatBase pSDCMTDECatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMTDECatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCMTDECatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMTDECatBase.setPSDCModelTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMTDECatBase.setPSDCModelTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMTDECatBase.setPSDCMTDECatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMTDECatBase.setPSDCMTDECatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMTDECatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCMTDECatBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCMTDECatBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMTDECatBase pSDCMTDECatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDECatBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCMTDECatBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCMTDECatBase.getPSDCModelTemplId() == null;
            }
            case 3: {
                return pSDCMTDECatBase.getPSDCModelTemplName() == null;
            }
            case 4: {
                return pSDCMTDECatBase.getPSDCMTDECatId() == null;
            }
            case 5: {
                return pSDCMTDECatBase.getPSDCMTDECatName() == null;
            }
            case 6: {
                return pSDCMTDECatBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCMTDECatBase.getUpdateMan() == null;
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
        return PSDCMTDECatBase.contains(this, n);
    }

    private static boolean contains(PSDCMTDECatBase pSDCMTDECatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMTDECatBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCMTDECatBase.isCreateManDirty();
            }
            case 2: {
                return pSDCMTDECatBase.isPSDCModelTemplIdDirty();
            }
            case 3: {
                return pSDCMTDECatBase.isPSDCModelTemplNameDirty();
            }
            case 4: {
                return pSDCMTDECatBase.isPSDCMTDECatIdDirty();
            }
            case 5: {
                return pSDCMTDECatBase.isPSDCMTDECatNameDirty();
            }
            case 6: {
                return pSDCMTDECatBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCMTDECatBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMTDECatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMTDECatBase pSDCMTDECatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMTDECatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getPSDCModelTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplid", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getPSDCModelTemplId()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getPSDCModelTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmodeltemplname", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getPSDCModelTemplName()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getPSDCMTDECatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmtdecatid", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getPSDCMTDECatId()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getPSDCMTDECatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmtdecatname", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getPSDCMTDECatName()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMTDECatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMTDECatBase.getJSONValue((Object)pSDCMTDECatBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMTDECatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMTDECatBase pSDCMTDECatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMTDECatBase.getCreateDate() != null) {
            object = pSDCMTDECatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMTDECatBase.getCreateMan() != null) {
            object = pSDCMTDECatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDECatBase.getPSDCModelTemplId() != null) {
            object = pSDCMTDECatBase.getPSDCModelTemplId();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDECatBase.getPSDCModelTemplName() != null) {
            object = pSDCMTDECatBase.getPSDCModelTemplName();
            xmlNode.setAttribute(FIELD_PSDCMODELTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDECatBase.getPSDCMTDECatId() != null) {
            object = pSDCMTDECatBase.getPSDCMTDECatId();
            xmlNode.setAttribute(FIELD_PSDCMTDECATID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDECatBase.getPSDCMTDECatName() != null) {
            object = pSDCMTDECatBase.getPSDCMTDECatName();
            xmlNode.setAttribute(FIELD_PSDCMTDECATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMTDECatBase.getUpdateDate() != null) {
            object = pSDCMTDECatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMTDECatBase.getUpdateMan() != null) {
            object = pSDCMTDECatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMTDECatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMTDECatBase pSDCMTDECatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMTDECatBase.isCreateDateDirty() && (bl || pSDCMTDECatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMTDECatBase.getCreateDate());
        }
        if (pSDCMTDECatBase.isCreateManDirty() && (bl || pSDCMTDECatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMTDECatBase.getCreateMan());
        }
        if (pSDCMTDECatBase.isPSDCModelTemplIdDirty() && (bl || pSDCMTDECatBase.getPSDCModelTemplId() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLID, (Object)pSDCMTDECatBase.getPSDCModelTemplId());
        }
        if (pSDCMTDECatBase.isPSDCModelTemplNameDirty() && (bl || pSDCMTDECatBase.getPSDCModelTemplName() != null)) {
            iDataObject.set(FIELD_PSDCMODELTEMPLNAME, (Object)pSDCMTDECatBase.getPSDCModelTemplName());
        }
        if (pSDCMTDECatBase.isPSDCMTDECatIdDirty() && (bl || pSDCMTDECatBase.getPSDCMTDECatId() != null)) {
            iDataObject.set(FIELD_PSDCMTDECATID, (Object)pSDCMTDECatBase.getPSDCMTDECatId());
        }
        if (pSDCMTDECatBase.isPSDCMTDECatNameDirty() && (bl || pSDCMTDECatBase.getPSDCMTDECatName() != null)) {
            iDataObject.set(FIELD_PSDCMTDECATNAME, (Object)pSDCMTDECatBase.getPSDCMTDECatName());
        }
        if (pSDCMTDECatBase.isUpdateDateDirty() && (bl || pSDCMTDECatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMTDECatBase.getUpdateDate());
        }
        if (pSDCMTDECatBase.isUpdateManDirty() && (bl || pSDCMTDECatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMTDECatBase.getUpdateMan());
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
        return PSDCMTDECatBase.remove(this, n);
    }

    private static boolean remove(PSDCMTDECatBase pSDCMTDECatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMTDECatBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCMTDECatBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCMTDECatBase.resetPSDCModelTemplId();
                return true;
            }
            case 3: {
                pSDCMTDECatBase.resetPSDCModelTemplName();
                return true;
            }
            case 4: {
                pSDCMTDECatBase.resetPSDCMTDECatId();
                return true;
            }
            case 5: {
                pSDCMTDECatBase.resetPSDCMTDECatName();
                return true;
            }
            case 6: {
                pSDCMTDECatBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCMTDECatBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCModelTempl getPSDCModelTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCModelTempl();
        }
        if (this.getPSDCModelTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDCModelTemplLock;
        synchronized (n) {
            if (this.psdcmodeltempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCModelTemplId(), (Object)this.psdcmodeltempl.getPSDCModelTemplId()) != 0L) {
                this.psdcmodeltempl = null;
            }
            if (this.psdcmodeltempl == null) {
                PSDCModelTempl pSDCModelTempl = new PSDCModelTempl();
                pSDCModelTempl.setPSDCModelTemplId(this.getPSDCModelTemplId());
                PSDCModelTemplService pSDCModelTemplService = (PSDCModelTemplService)ServiceGlobal.getService(PSDCModelTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDCModelTemplService.autoGet(pSDCModelTempl);
                this.psdcmodeltempl = pSDCModelTempl;
            }
            return this.psdcmodeltempl;
        }
    }

    private PSDCMTDECatBase getProxyEntity() {
        return this.proxyPSDCMTDECatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMTDECatBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMTDECatBase) {
            this.proxyPSDCMTDECatBase = (PSDCMTDECatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMTDECatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLID, 2);
        fieldIndexMap.put(FIELD_PSDCMODELTEMPLNAME, 3);
        fieldIndexMap.put(FIELD_PSDCMTDECATID, 4);
        fieldIndexMap.put(FIELD_PSDCMTDECATNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

