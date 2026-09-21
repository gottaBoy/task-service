/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.sysmodel.util.dynaclient.entity;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaCodeListInst;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaCodeListInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaCodeListInstBase.class);
    public static final String FIELD_PSDYNACODELISTINSTID = "PSDYNACODELISTINSTID";
    public static final String FIELD_PSDYNACODELISTINSTNAME = "PSDYNACODELISTINSTNAME";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_PSDYNACODELISTID = "PSDYNACODELISTID";
    private static final int INDEX_PSDYNACODELISTINSTID = 0;
    private static final int INDEX_PSDYNACODELISTINSTNAME = 1;
    private static final int INDEX_DYNAMODEL = 2;
    private static final int INDEX_PSDYNAINSTID = 3;
    private static final int INDEX_INSTVER = 4;
    private static final int INDEX_PSDYNACODELISTID = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaCodeListInstBase proxyPSDynaCodeListInstBase = null;
    private boolean psdynacodelistinstidDirtyFlag = false;
    private boolean psdynacodelistinstnameDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean psdynacodelistidDirtyFlag = false;
    @Column(name="psdynacodelistinstid")
    private String psdynacodelistinstid;
    @Column(name="psdynacodelistinstname")
    private String psdynacodelistinstname;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="instver")
    private Integer instver;
    @Column(name="psdynacodelistid")
    private String psdynacodelistid;

    static {
        fieldIndexMap.put(FIELD_PSDYNACODELISTINSTID, 0);
        fieldIndexMap.put(FIELD_PSDYNACODELISTINSTNAME, 1);
        fieldIndexMap.put(FIELD_DYNAMODEL, 2);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 3);
        fieldIndexMap.put(FIELD_INSTVER, 4);
        fieldIndexMap.put(FIELD_PSDYNACODELISTID, 5);
    }

    public void setPSDynaCodeListInstId(String psdynacodelistinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListInstId(psdynacodelistinstid);
            return;
        }
        if (psdynacodelistinstid != null && (psdynacodelistinstid = StringHelper.trimRight((String)psdynacodelistinstid)).length() == 0) {
            psdynacodelistinstid = null;
        }
        this.psdynacodelistinstid = psdynacodelistinstid;
        this.psdynacodelistinstidDirtyFlag = true;
    }

    public String getPSDynaCodeListInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListInstId();
        }
        return this.psdynacodelistinstid;
    }

    public boolean isPSDynaCodeListInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListInstIdDirty();
        }
        return this.psdynacodelistinstidDirtyFlag;
    }

    public void resetPSDynaCodeListInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListInstId();
            return;
        }
        this.psdynacodelistinstidDirtyFlag = false;
        this.psdynacodelistinstid = null;
    }

    public void setPSDynaCodeListInstName(String psdynacodelistinstname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListInstName(psdynacodelistinstname);
            return;
        }
        if (psdynacodelistinstname != null && (psdynacodelistinstname = StringHelper.trimRight((String)psdynacodelistinstname)).length() == 0) {
            psdynacodelistinstname = null;
        }
        this.psdynacodelistinstname = psdynacodelistinstname;
        this.psdynacodelistinstnameDirtyFlag = true;
    }

    public String getPSDynaCodeListInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListInstName();
        }
        return this.psdynacodelistinstname;
    }

    public boolean isPSDynaCodeListInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListInstNameDirty();
        }
        return this.psdynacodelistinstnameDirtyFlag;
    }

    public void resetPSDynaCodeListInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListInstName();
            return;
        }
        this.psdynacodelistinstnameDirtyFlag = false;
        this.psdynacodelistinstname = null;
    }

    public void setDynaModel(String dynamodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(dynamodel);
            return;
        }
        if (dynamodel != null && (dynamodel = StringHelper.trimRight((String)dynamodel)).length() == 0) {
            dynamodel = null;
        }
        this.dynamodel = dynamodel;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setPSDynaInstId(String psdynainstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(psdynainstid);
            return;
        }
        if (psdynainstid != null && (psdynainstid = StringHelper.trimRight((String)psdynainstid)).length() == 0) {
            psdynainstid = null;
        }
        this.psdynainstid = psdynainstid;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setInstVer(Integer instver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(instver);
            return;
        }
        this.instver = instver;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
    }

    public void setPSDynaCodeListId(String psdynacodelistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListId(psdynacodelistid);
            return;
        }
        if (psdynacodelistid != null && (psdynacodelistid = StringHelper.trimRight((String)psdynacodelistid)).length() == 0) {
            psdynacodelistid = null;
        }
        this.psdynacodelistid = psdynacodelistid;
        this.psdynacodelistidDirtyFlag = true;
    }

    public String getPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListId();
        }
        return this.psdynacodelistid;
    }

    public boolean isPSDynaCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListIdDirty();
        }
        return this.psdynacodelistidDirtyFlag;
    }

    public void resetPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListId();
            return;
        }
        this.psdynacodelistidDirtyFlag = false;
        this.psdynacodelistid = null;
    }

    protected void onReset() {
        PSDynaCodeListInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaCodeListInstBase et) {
        et.resetPSDynaCodeListInstId();
        et.resetPSDynaCodeListInstName();
        et.resetDynaModel();
        et.resetPSDynaInstId();
        et.resetInstVer();
        et.resetPSDynaCodeListId();
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isPSDynaCodeListInstIdDirty()) {
            params.put(FIELD_PSDYNACODELISTINSTID, this.getPSDynaCodeListInstId());
        }
        if (!bDirtyOnly || this.isPSDynaCodeListInstNameDirty()) {
            params.put(FIELD_PSDYNACODELISTINSTNAME, this.getPSDynaCodeListInstName());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isPSDynaInstIdDirty()) {
            params.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bDirtyOnly || this.isInstVerDirty()) {
            params.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bDirtyOnly || this.isPSDynaCodeListIdDirty()) {
            params.put(FIELD_PSDYNACODELISTID, this.getPSDynaCodeListId());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return PSDynaCodeListInstBase.get(this, index);
    }

    private static Object get(PSDynaCodeListInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaCodeListInstId();
            }
            case 1: {
                return et.getPSDynaCodeListInstName();
            }
            case 2: {
                return et.getDynaModel();
            }
            case 3: {
                return et.getPSDynaInstId();
            }
            case 4: {
                return et.getInstVer();
            }
            case 5: {
                return et.getPSDynaCodeListId();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        PSDynaCodeListInstBase.set(this, index, objValue);
    }

    private static void set(PSDynaCodeListInstBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setPSDynaCodeListInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 1: {
                et.setPSDynaCodeListInstName(DataObject.getStringValue((Object)obj));
                return;
            }
            case 2: {
                et.setDynaModel(DataObject.getStringValue((Object)obj));
                return;
            }
            case 3: {
                et.setPSDynaInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 4: {
                et.setInstVer(DataObject.getIntegerValue((Object)obj));
                return;
            }
            case 5: {
                et.setPSDynaCodeListId(DataObject.getStringValue((Object)obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return PSDynaCodeListInstBase.isNull(this, index);
    }

    private static boolean isNull(PSDynaCodeListInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaCodeListInstId() == null;
            }
            case 1: {
                return et.getPSDynaCodeListInstName() == null;
            }
            case 2: {
                return et.getDynaModel() == null;
            }
            case 3: {
                return et.getPSDynaInstId() == null;
            }
            case 4: {
                return et.getInstVer() == null;
            }
            case 5: {
                return et.getPSDynaCodeListId() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return PSDynaCodeListInstBase.contains(this, index);
    }

    private static boolean contains(PSDynaCodeListInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isPSDynaCodeListInstIdDirty();
            }
            case 1: {
                return et.isPSDynaCodeListInstNameDirty();
            }
            case 2: {
                return et.isDynaModelDirty();
            }
            case 3: {
                return et.isPSDynaInstIdDirty();
            }
            case 4: {
                return et.isInstVerDirty();
            }
            case 5: {
                return et.isPSDynaCodeListIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PSDynaCodeListInstBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PSDynaCodeListInstBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getPSDynaCodeListInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynacodelistinstid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getPSDynaCodeListInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaCodeListInstName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynacodelistinstname", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getPSDynaCodeListInstName()), (boolean)false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"dynamodel", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getDynaModel()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynainstid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getPSDynaInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"instver", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getInstVer()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynacodelistid", (Object)PSDynaCodeListInstBase.getJSONValue((Object)et.getPSDynaCodeListId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PSDynaCodeListInstBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PSDynaCodeListInstBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getPSDynaCodeListInstId() != null) {
            obj = et.getPSDynaCodeListInstId();
            node.setAttribute(FIELD_PSDYNACODELISTINSTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPSDynaCodeListInstName() != null) {
            obj = et.getPSDynaCodeListInstName();
            node.setAttribute(FIELD_PSDYNACODELISTINSTNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            obj = et.getPSDynaInstId();
            node.setAttribute(FIELD_PSDYNAINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            obj = et.getInstVer();
            node.setAttribute(FIELD_INSTVER, obj == null ? "" : StringHelper.format((String)"%1$s", (Object)obj));
        }
        if (bIncEmpty || et.getPSDynaCodeListId() != null) {
            obj = et.getPSDynaCodeListId();
            node.setAttribute(FIELD_PSDYNACODELISTID, obj == null ? "" : (String)obj);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaCodeListInstBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PSDynaCodeListInstBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isPSDynaCodeListInstIdDirty() && (bIncEmpty || et.getPSDynaCodeListInstId() != null)) {
            dst.set(FIELD_PSDYNACODELISTINSTID, (Object)et.getPSDynaCodeListInstId());
        }
        if (et.isPSDynaCodeListInstNameDirty() && (bIncEmpty || et.getPSDynaCodeListInstName() != null)) {
            dst.set(FIELD_PSDYNACODELISTINSTNAME, (Object)et.getPSDynaCodeListInstName());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, (Object)et.getDynaModel());
        }
        if (et.isPSDynaInstIdDirty() && (bIncEmpty || et.getPSDynaInstId() != null)) {
            dst.set(FIELD_PSDYNAINSTID, (Object)et.getPSDynaInstId());
        }
        if (et.isInstVerDirty() && (bIncEmpty || et.getInstVer() != null)) {
            dst.set(FIELD_INSTVER, (Object)et.getInstVer());
        }
        if (et.isPSDynaCodeListIdDirty() && (bIncEmpty || et.getPSDynaCodeListId() != null)) {
            dst.set(FIELD_PSDYNACODELISTID, (Object)et.getPSDynaCodeListId());
        }
    }

    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty((String)strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return PSDynaCodeListInstBase.remove(this, index);
    }

    private static boolean remove(PSDynaCodeListInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetPSDynaCodeListInstId();
                return true;
            }
            case 1: {
                et.resetPSDynaCodeListInstName();
                return true;
            }
            case 2: {
                et.resetDynaModel();
                return true;
            }
            case 3: {
                et.resetPSDynaInstId();
                return true;
            }
            case 4: {
                et.resetInstVer();
                return true;
            }
            case 5: {
                et.resetPSDynaCodeListId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDynaCodeListInstBase getProxyEntity() {
        return this.proxyPSDynaCodeListInstBase;
    }

    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaCodeListInstBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PSDynaCodeListInst) {
            this.proxyPSDynaCodeListInstBase = (PSDynaCodeListInst)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }
}

