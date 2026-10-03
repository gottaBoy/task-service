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
package net.ibizsys.pscore.srv.dynasys.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaWFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_PSDYNAWFID = "PSDYNAWFID";
    public static final String FIELD_PSDYNAWFNAME = "PSDYNAWFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDYNASYSID = 3;
    private static final int INDEX_PSDYNASYSNAME = 4;
    private static final int INDEX_PSDYNAWFID = 5;
    private static final int INDEX_PSDYNAWFNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWFBase proxyPSDynaWFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
    private boolean psdynawfidDirtyFlag = false;
    private boolean psdynawfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
    @Column(name="psdynawfid")
    private String psdynawfid;
    @Column(name="psdynawfname")
    private String psdynawfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDynaSysLock = new Integer(1);
    private PSDynaSys psdynasys = null;
    private Integer objPSDynaWFVersLock = new Integer(1);
    private ArrayList<PSDynaWFVer> psdynawfvers = null;

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

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
    }

    public void setPSDynaWFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfid = string;
        this.psdynawfidDirtyFlag = true;
    }

    public String getPSDynaWFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFId();
        }
        return this.psdynawfid;
    }

    public boolean isPSDynaWFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFIdDirty();
        }
        return this.psdynawfidDirtyFlag;
    }

    public void resetPSDynaWFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFId();
            return;
        }
        this.psdynawfidDirtyFlag = false;
        this.psdynawfid = null;
    }

    public void setPSDynaWFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynawfname = string;
        this.psdynawfnameDirtyFlag = true;
    }

    public String getPSDynaWFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFName();
        }
        return this.psdynawfname;
    }

    public boolean isPSDynaWFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFNameDirty();
        }
        return this.psdynawfnameDirtyFlag;
    }

    public void resetPSDynaWFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFName();
            return;
        }
        this.psdynawfnameDirtyFlag = false;
        this.psdynawfname = null;
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
        PSDynaWFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWFBase pSDynaWFBase) {
        pSDynaWFBase.resetCreateDate();
        pSDynaWFBase.resetCreateMan();
        pSDynaWFBase.resetMemo();
        pSDynaWFBase.resetPSDynaSysId();
        pSDynaWFBase.resetPSDynaSysName();
        pSDynaWFBase.resetPSDynaWFId();
        pSDynaWFBase.resetPSDynaWFName();
        pSDynaWFBase.resetUpdateDate();
        pSDynaWFBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
        }
        if (!bl || this.isPSDynaWFIdDirty()) {
            hashMap.put(FIELD_PSDYNAWFID, this.getPSDynaWFId());
        }
        if (!bl || this.isPSDynaWFNameDirty()) {
            hashMap.put(FIELD_PSDYNAWFNAME, this.getPSDynaWFName());
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
        return PSDynaWFBase.get(this, n);
    }

    private static Object get(PSDynaWFBase pSDynaWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFBase.getCreateDate();
            }
            case 1: {
                return pSDynaWFBase.getCreateMan();
            }
            case 2: {
                return pSDynaWFBase.getMemo();
            }
            case 3: {
                return pSDynaWFBase.getPSDynaSysId();
            }
            case 4: {
                return pSDynaWFBase.getPSDynaSysName();
            }
            case 5: {
                return pSDynaWFBase.getPSDynaWFId();
            }
            case 6: {
                return pSDynaWFBase.getPSDynaWFName();
            }
            case 7: {
                return pSDynaWFBase.getUpdateDate();
            }
            case 8: {
                return pSDynaWFBase.getUpdateMan();
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
        PSDynaWFBase.set(this, n, object);
    }

    private static void set(PSDynaWFBase pSDynaWFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaWFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaWFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaWFBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaWFBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaWFBase.setPSDynaWFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaWFBase.setPSDynaWFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaWFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDynaWFBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaWFBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaWFBase pSDynaWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaWFBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaWFBase.getMemo() == null;
            }
            case 3: {
                return pSDynaWFBase.getPSDynaSysId() == null;
            }
            case 4: {
                return pSDynaWFBase.getPSDynaSysName() == null;
            }
            case 5: {
                return pSDynaWFBase.getPSDynaWFId() == null;
            }
            case 6: {
                return pSDynaWFBase.getPSDynaWFName() == null;
            }
            case 7: {
                return pSDynaWFBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDynaWFBase.getUpdateMan() == null;
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
        return PSDynaWFBase.contains(this, n);
    }

    private static boolean contains(PSDynaWFBase pSDynaWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaWFBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaWFBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaWFBase.isMemoDirty();
            }
            case 3: {
                return pSDynaWFBase.isPSDynaSysIdDirty();
            }
            case 4: {
                return pSDynaWFBase.isPSDynaSysNameDirty();
            }
            case 5: {
                return pSDynaWFBase.isPSDynaWFIdDirty();
            }
            case 6: {
                return pSDynaWFBase.isPSDynaWFNameDirty();
            }
            case 7: {
                return pSDynaWFBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDynaWFBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaWFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaWFBase pSDynaWFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaWFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getPSDynaWFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfid", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getPSDynaWFId()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getPSDynaWFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynawfname", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getPSDynaWFName()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaWFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaWFBase.getJSONValue((Object)pSDynaWFBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaWFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaWFBase pSDynaWFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaWFBase.getCreateDate() != null) {
            object = pSDynaWFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFBase.getCreateMan() != null) {
            object = pSDynaWFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getMemo() != null) {
            object = pSDynaWFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getPSDynaSysId() != null) {
            object = pSDynaWFBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getPSDynaSysName() != null) {
            object = pSDynaWFBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getPSDynaWFId() != null) {
            object = pSDynaWFBase.getPSDynaWFId();
            xmlNode.setAttribute(FIELD_PSDYNAWFID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getPSDynaWFName() != null) {
            object = pSDynaWFBase.getPSDynaWFName();
            xmlNode.setAttribute(FIELD_PSDYNAWFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaWFBase.getUpdateDate() != null) {
            object = pSDynaWFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaWFBase.getUpdateMan() != null) {
            object = pSDynaWFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaWFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaWFBase pSDynaWFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaWFBase.isCreateDateDirty() && (bl || pSDynaWFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaWFBase.getCreateDate());
        }
        if (pSDynaWFBase.isCreateManDirty() && (bl || pSDynaWFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaWFBase.getCreateMan());
        }
        if (pSDynaWFBase.isMemoDirty() && (bl || pSDynaWFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaWFBase.getMemo());
        }
        if (pSDynaWFBase.isPSDynaSysIdDirty() && (bl || pSDynaWFBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaWFBase.getPSDynaSysId());
        }
        if (pSDynaWFBase.isPSDynaSysNameDirty() && (bl || pSDynaWFBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaWFBase.getPSDynaSysName());
        }
        if (pSDynaWFBase.isPSDynaWFIdDirty() && (bl || pSDynaWFBase.getPSDynaWFId() != null)) {
            iDataObject.set(FIELD_PSDYNAWFID, (Object)pSDynaWFBase.getPSDynaWFId());
        }
        if (pSDynaWFBase.isPSDynaWFNameDirty() && (bl || pSDynaWFBase.getPSDynaWFName() != null)) {
            iDataObject.set(FIELD_PSDYNAWFNAME, (Object)pSDynaWFBase.getPSDynaWFName());
        }
        if (pSDynaWFBase.isUpdateDateDirty() && (bl || pSDynaWFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaWFBase.getUpdateDate());
        }
        if (pSDynaWFBase.isUpdateManDirty() && (bl || pSDynaWFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaWFBase.getUpdateMan());
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
        return PSDynaWFBase.remove(this, n);
    }

    private static boolean remove(PSDynaWFBase pSDynaWFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaWFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaWFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaWFBase.resetMemo();
                return true;
            }
            case 3: {
                pSDynaWFBase.resetPSDynaSysId();
                return true;
            }
            case 4: {
                pSDynaWFBase.resetPSDynaSysName();
                return true;
            }
            case 5: {
                pSDynaWFBase.resetPSDynaWFId();
                return true;
            }
            case 6: {
                pSDynaWFBase.resetPSDynaWFName();
                return true;
            }
            case 7: {
                pSDynaWFBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDynaWFBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaSys getPSDynaSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSys();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        Integer n = this.objPSDynaSysLock;
        synchronized (n) {
            if (this.psdynasys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaSysId(), (Object)this.psdynasys.getPSDynaSysId()) != 0L) {
                this.psdynasys = null;
            }
            if (this.psdynasys == null) {
                PSDynaSys pSDynaSys = new PSDynaSys();
                pSDynaSys.setPSDynaSysId(this.getPSDynaSysId());
                PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)this.getSessionFactory());
                pSDynaSysService.autoGet(pSDynaSys);
                this.psdynasys = pSDynaSys;
            }
            return this.psdynasys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaWFVer> getPSDynaWFVers() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVers();
        }
        if (this.getPSDynaWFId() == null) {
            return null;
        }
        PSDynaWFVerService pSDynaWFVerService = (PSDynaWFVerService)ServiceGlobal.getService(PSDynaWFVerService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaWFVersLock;
        synchronized (n) {
            if (this.psdynawfvers == null) {
                this.psdynawfvers = pSDynaWFVerService.selectByPSDynaWF(this);
            }
            return this.psdynawfvers;
        }
    }

    private PSDynaWFBase getProxyEntity() {
        return this.proxyPSDynaWFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaWFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaWFBase) {
            this.proxyPSDynaWFBase = (PSDynaWFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 3);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 4);
        fieldIndexMap.put(FIELD_PSDYNAWFID, 5);
        fieldIndexMap.put(FIELD_PSDYNAWFNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

