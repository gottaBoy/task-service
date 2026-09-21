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
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVerInst;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaWFVerInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWFVerInstBase.class);
    public static final String FIELD_PSDYNAWFVERINSTID = "PSDYNAWFVERINSTID";
    public static final String FIELD_PSDYNAWFVERINSTNAME = "PSDYNAWFVERINSTNAME";
    public static final String FIELD_WFVERSION = "WFVERSION";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
    private static final int INDEX_PSDYNAWFVERINSTID = 0;
    private static final int INDEX_PSDYNAWFVERINSTNAME = 1;
    private static final int INDEX_WFVERSION = 2;
    private static final int INDEX_DYNAMODEL = 3;
    private static final int INDEX_INSTVER = 4;
    private static final int INDEX_PSDYNAINSTID = 5;
    private static final int INDEX_PSDYNAWFVERID = 6;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWFVerInstBase proxyPSDynaWFVerInstBase = null;
    private boolean psdynawfverinstidDirtyFlag = false;
    private boolean psdynawfverinstnameDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psdynawfveridDirtyFlag = false;
    @Column(name="psdynawfverinstid")
    private String psdynawfverinstid;
    @Column(name="psdynawfverinstname")
    private String psdynawfverinstname;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="instver")
    private Integer instver;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psdynawfverid")
    private String psdynawfverid;

    static {
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTID, 0);
        fieldIndexMap.put(FIELD_PSDYNAWFVERINSTNAME, 1);
        fieldIndexMap.put(FIELD_WFVERSION, 2);
        fieldIndexMap.put(FIELD_DYNAMODEL, 3);
        fieldIndexMap.put(FIELD_INSTVER, 4);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 5);
        fieldIndexMap.put(FIELD_PSDYNAWFVERID, 6);
    }

    public void setPSDynaWFVerInstId(String psdynawfverinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstId(psdynawfverinstid);
            return;
        }
        if (psdynawfverinstid != null && (psdynawfverinstid = StringHelper.trimRight((String)psdynawfverinstid)).length() == 0) {
            psdynawfverinstid = null;
        }
        this.psdynawfverinstid = psdynawfverinstid;
        this.psdynawfverinstidDirtyFlag = true;
    }

    public String getPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstId();
        }
        return this.psdynawfverinstid;
    }

    public boolean isPSDynaWFVerInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstIdDirty();
        }
        return this.psdynawfverinstidDirtyFlag;
    }

    public void resetPSDynaWFVerInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstId();
            return;
        }
        this.psdynawfverinstidDirtyFlag = false;
        this.psdynawfverinstid = null;
    }

    public void setPSDynaWFVerInstName(String psdynawfverinstname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerInstName(psdynawfverinstname);
            return;
        }
        if (psdynawfverinstname != null && (psdynawfverinstname = StringHelper.trimRight((String)psdynawfverinstname)).length() == 0) {
            psdynawfverinstname = null;
        }
        this.psdynawfverinstname = psdynawfverinstname;
        this.psdynawfverinstnameDirtyFlag = true;
    }

    public String getPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerInstName();
        }
        return this.psdynawfverinstname;
    }

    public boolean isPSDynaWFVerInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerInstNameDirty();
        }
        return this.psdynawfverinstnameDirtyFlag;
    }

    public void resetPSDynaWFVerInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerInstName();
            return;
        }
        this.psdynawfverinstnameDirtyFlag = false;
        this.psdynawfverinstname = null;
    }

    public void setWFVersion(Integer wfversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
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

    public void setPSDynaWFVerId(String psdynawfverid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerId(psdynawfverid);
            return;
        }
        if (psdynawfverid != null && (psdynawfverid = StringHelper.trimRight((String)psdynawfverid)).length() == 0) {
            psdynawfverid = null;
        }
        this.psdynawfverid = psdynawfverid;
        this.psdynawfveridDirtyFlag = true;
    }

    public String getPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerId();
        }
        return this.psdynawfverid;
    }

    public boolean isPSDynaWFVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerIdDirty();
        }
        return this.psdynawfveridDirtyFlag;
    }

    public void resetPSDynaWFVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerId();
            return;
        }
        this.psdynawfveridDirtyFlag = false;
        this.psdynawfverid = null;
    }

    protected void onReset() {
        PSDynaWFVerInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWFVerInstBase et) {
        et.resetPSDynaWFVerInstId();
        et.resetPSDynaWFVerInstName();
        et.resetWFVersion();
        et.resetDynaModel();
        et.resetInstVer();
        et.resetPSDynaInstId();
        et.resetPSDynaWFVerId();
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isPSDynaWFVerInstIdDirty()) {
            params.put(FIELD_PSDYNAWFVERINSTID, this.getPSDynaWFVerInstId());
        }
        if (!bDirtyOnly || this.isPSDynaWFVerInstNameDirty()) {
            params.put(FIELD_PSDYNAWFVERINSTNAME, this.getPSDynaWFVerInstName());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isInstVerDirty()) {
            params.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bDirtyOnly || this.isPSDynaInstIdDirty()) {
            params.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bDirtyOnly || this.isPSDynaWFVerIdDirty()) {
            params.put(FIELD_PSDYNAWFVERID, this.getPSDynaWFVerId());
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
        return PSDynaWFVerInstBase.get(this, index);
    }

    private static Object get(PSDynaWFVerInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaWFVerInstId();
            }
            case 1: {
                return et.getPSDynaWFVerInstName();
            }
            case 2: {
                return et.getWFVersion();
            }
            case 3: {
                return et.getDynaModel();
            }
            case 4: {
                return et.getInstVer();
            }
            case 5: {
                return et.getPSDynaInstId();
            }
            case 6: {
                return et.getPSDynaWFVerId();
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
        PSDynaWFVerInstBase.set(this, index, objValue);
    }

    private static void set(PSDynaWFVerInstBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setPSDynaWFVerInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 1: {
                et.setPSDynaWFVerInstName(DataObject.getStringValue((Object)obj));
                return;
            }
            case 2: {
                et.setWFVersion(DataObject.getIntegerValue((Object)obj));
                return;
            }
            case 3: {
                et.setDynaModel(DataObject.getStringValue((Object)obj));
                return;
            }
            case 4: {
                et.setInstVer(DataObject.getIntegerValue((Object)obj));
                return;
            }
            case 5: {
                et.setPSDynaInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 6: {
                et.setPSDynaWFVerId(DataObject.getStringValue((Object)obj));
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
        return PSDynaWFVerInstBase.isNull(this, index);
    }

    private static boolean isNull(PSDynaWFVerInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaWFVerInstId() == null;
            }
            case 1: {
                return et.getPSDynaWFVerInstName() == null;
            }
            case 2: {
                return et.getWFVersion() == null;
            }
            case 3: {
                return et.getDynaModel() == null;
            }
            case 4: {
                return et.getInstVer() == null;
            }
            case 5: {
                return et.getPSDynaInstId() == null;
            }
            case 6: {
                return et.getPSDynaWFVerId() == null;
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
        return PSDynaWFVerInstBase.contains(this, index);
    }

    private static boolean contains(PSDynaWFVerInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isPSDynaWFVerInstIdDirty();
            }
            case 1: {
                return et.isPSDynaWFVerInstNameDirty();
            }
            case 2: {
                return et.isWFVersionDirty();
            }
            case 3: {
                return et.isDynaModelDirty();
            }
            case 4: {
                return et.isInstVerDirty();
            }
            case 5: {
                return et.isPSDynaInstIdDirty();
            }
            case 6: {
                return et.isPSDynaWFVerIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PSDynaWFVerInstBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PSDynaWFVerInstBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getPSDynaWFVerInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfverinstid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getPSDynaWFVerInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaWFVerInstName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfverinstname", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getPSDynaWFVerInstName()), (boolean)false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"wfversion", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getWFVersion()), (boolean)false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"dynamodel", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getDynaModel()), (boolean)false);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"instver", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getInstVer()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynainstid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getPSDynaInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfverid", (Object)PSDynaWFVerInstBase.getJSONValue((Object)et.getPSDynaWFVerId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PSDynaWFVerInstBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PSDynaWFVerInstBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getPSDynaWFVerInstId() != null) {
            obj = et.getPSDynaWFVerInstId();
            node.setAttribute(FIELD_PSDYNAWFVERINSTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPSDynaWFVerInstName() != null) {
            obj = et.getPSDynaWFVerInstName();
            node.setAttribute(FIELD_PSDYNAWFVERINSTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format((String)"%1$s", (Object)obj));
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            obj = et.getInstVer();
            node.setAttribute(FIELD_INSTVER, obj == null ? "" : StringHelper.format((String)"%1$s", (Object)obj));
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            obj = et.getPSDynaInstId();
            node.setAttribute(FIELD_PSDYNAINSTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPSDynaWFVerId() != null) {
            obj = et.getPSDynaWFVerId();
            node.setAttribute(FIELD_PSDYNAWFVERID, obj == null ? "" : (String)obj);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaWFVerInstBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PSDynaWFVerInstBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isPSDynaWFVerInstIdDirty() && (bIncEmpty || et.getPSDynaWFVerInstId() != null)) {
            dst.set(FIELD_PSDYNAWFVERINSTID, (Object)et.getPSDynaWFVerInstId());
        }
        if (et.isPSDynaWFVerInstNameDirty() && (bIncEmpty || et.getPSDynaWFVerInstName() != null)) {
            dst.set(FIELD_PSDYNAWFVERINSTNAME, (Object)et.getPSDynaWFVerInstName());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, (Object)et.getWFVersion());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, (Object)et.getDynaModel());
        }
        if (et.isInstVerDirty() && (bIncEmpty || et.getInstVer() != null)) {
            dst.set(FIELD_INSTVER, (Object)et.getInstVer());
        }
        if (et.isPSDynaInstIdDirty() && (bIncEmpty || et.getPSDynaInstId() != null)) {
            dst.set(FIELD_PSDYNAINSTID, (Object)et.getPSDynaInstId());
        }
        if (et.isPSDynaWFVerIdDirty() && (bIncEmpty || et.getPSDynaWFVerId() != null)) {
            dst.set(FIELD_PSDYNAWFVERID, (Object)et.getPSDynaWFVerId());
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
        return PSDynaWFVerInstBase.remove(this, index);
    }

    private static boolean remove(PSDynaWFVerInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetPSDynaWFVerInstId();
                return true;
            }
            case 1: {
                et.resetPSDynaWFVerInstName();
                return true;
            }
            case 2: {
                et.resetWFVersion();
                return true;
            }
            case 3: {
                et.resetDynaModel();
                return true;
            }
            case 4: {
                et.resetInstVer();
                return true;
            }
            case 5: {
                et.resetPSDynaInstId();
                return true;
            }
            case 6: {
                et.resetPSDynaWFVerId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDynaWFVerInstBase getProxyEntity() {
        return this.proxyPSDynaWFVerInstBase;
    }

    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaWFVerInstBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PSDynaWFVerInst) {
            this.proxyPSDynaWFVerInstBase = (PSDynaWFVerInst)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }
}

