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
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaWFVer;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaWFVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaWFVerBase.class);
    public static final String FIELD_PSDYNAWFVERID = "PSDYNAWFVERID";
    public static final String FIELD_PSDYNAWFVERNAME = "PSDYNAWFVERNAME";
    public static final String FIELD_PSDYNAWFID = "PSDYNAWFID";
    public static final String FIELD_PSDYNAWFNAME = "PSDYNAWFNAME";
    private static final int INDEX_PSDYNAWFVERID = 0;
    private static final int INDEX_PSDYNAWFVERNAME = 1;
    private static final int INDEX_PSDYNAWFID = 2;
    private static final int INDEX_PSDYNAWFNAME = 3;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaWFVerBase proxyPSDynaWFVerBase = null;
    private boolean psdynawfveridDirtyFlag = false;
    private boolean psdynawfvernameDirtyFlag = false;
    private boolean psdynawfidDirtyFlag = false;
    private boolean psdynawfnameDirtyFlag = false;
    @Column(name="psdynawfverid")
    private String psdynawfverid;
    @Column(name="psdynawfvername")
    private String psdynawfvername;
    @Column(name="psdynawfid")
    private String psdynawfid;
    @Column(name="psdynawfname")
    private String psdynawfname;

    static {
        fieldIndexMap.put(FIELD_PSDYNAWFVERID, 0);
        fieldIndexMap.put(FIELD_PSDYNAWFVERNAME, 1);
        fieldIndexMap.put(FIELD_PSDYNAWFID, 2);
        fieldIndexMap.put(FIELD_PSDYNAWFNAME, 3);
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

    public void setPSDynaWFVerName(String psdynawfvername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFVerName(psdynawfvername);
            return;
        }
        if (psdynawfvername != null && (psdynawfvername = StringHelper.trimRight((String)psdynawfvername)).length() == 0) {
            psdynawfvername = null;
        }
        this.psdynawfvername = psdynawfvername;
        this.psdynawfvernameDirtyFlag = true;
    }

    public String getPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaWFVerName();
        }
        return this.psdynawfvername;
    }

    public boolean isPSDynaWFVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaWFVerNameDirty();
        }
        return this.psdynawfvernameDirtyFlag;
    }

    public void resetPSDynaWFVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaWFVerName();
            return;
        }
        this.psdynawfvernameDirtyFlag = false;
        this.psdynawfvername = null;
    }

    public void setPSDynaWFId(String psdynawfid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFId(psdynawfid);
            return;
        }
        if (psdynawfid != null && (psdynawfid = StringHelper.trimRight((String)psdynawfid)).length() == 0) {
            psdynawfid = null;
        }
        this.psdynawfid = psdynawfid;
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

    public void setPSDynaWFName(String psdynawfname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaWFName(psdynawfname);
            return;
        }
        if (psdynawfname != null && (psdynawfname = StringHelper.trimRight((String)psdynawfname)).length() == 0) {
            psdynawfname = null;
        }
        this.psdynawfname = psdynawfname;
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

    protected void onReset() {
        PSDynaWFVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaWFVerBase et) {
        et.resetPSDynaWFVerId();
        et.resetPSDynaWFVerName();
        et.resetPSDynaWFId();
        et.resetPSDynaWFName();
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isPSDynaWFVerIdDirty()) {
            params.put(FIELD_PSDYNAWFVERID, this.getPSDynaWFVerId());
        }
        if (!bDirtyOnly || this.isPSDynaWFVerNameDirty()) {
            params.put(FIELD_PSDYNAWFVERNAME, this.getPSDynaWFVerName());
        }
        if (!bDirtyOnly || this.isPSDynaWFIdDirty()) {
            params.put(FIELD_PSDYNAWFID, this.getPSDynaWFId());
        }
        if (!bDirtyOnly || this.isPSDynaWFNameDirty()) {
            params.put(FIELD_PSDYNAWFNAME, this.getPSDynaWFName());
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
        return PSDynaWFVerBase.get(this, index);
    }

    private static Object get(PSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaWFVerId();
            }
            case 1: {
                return et.getPSDynaWFVerName();
            }
            case 2: {
                return et.getPSDynaWFId();
            }
            case 3: {
                return et.getPSDynaWFName();
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
        PSDynaWFVerBase.set(this, index, objValue);
    }

    private static void set(PSDynaWFVerBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setPSDynaWFVerId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 1: {
                et.setPSDynaWFVerName(DataObject.getStringValue((Object)obj));
                return;
            }
            case 2: {
                et.setPSDynaWFId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 3: {
                et.setPSDynaWFName(DataObject.getStringValue((Object)obj));
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
        return PSDynaWFVerBase.isNull(this, index);
    }

    private static boolean isNull(PSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaWFVerId() == null;
            }
            case 1: {
                return et.getPSDynaWFVerName() == null;
            }
            case 2: {
                return et.getPSDynaWFId() == null;
            }
            case 3: {
                return et.getPSDynaWFName() == null;
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
        return PSDynaWFVerBase.contains(this, index);
    }

    private static boolean contains(PSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isPSDynaWFVerIdDirty();
            }
            case 1: {
                return et.isPSDynaWFVerNameDirty();
            }
            case 2: {
                return et.isPSDynaWFIdDirty();
            }
            case 3: {
                return et.isPSDynaWFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PSDynaWFVerBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PSDynaWFVerBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getPSDynaWFVerId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfverid", (Object)PSDynaWFVerBase.getJSONValue((Object)et.getPSDynaWFVerId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaWFVerName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfvername", (Object)PSDynaWFVerBase.getJSONValue((Object)et.getPSDynaWFVerName()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaWFId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfid", (Object)PSDynaWFVerBase.getJSONValue((Object)et.getPSDynaWFId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaWFName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynawfname", (Object)PSDynaWFVerBase.getJSONValue((Object)et.getPSDynaWFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PSDynaWFVerBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PSDynaWFVerBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        String obj;
        if (bIncEmpty || et.getPSDynaWFVerId() != null) {
            obj = et.getPSDynaWFVerId();
            node.setAttribute(FIELD_PSDYNAWFVERID, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSDynaWFVerName() != null) {
            obj = et.getPSDynaWFVerName();
            node.setAttribute(FIELD_PSDYNAWFVERNAME, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSDynaWFId() != null) {
            obj = et.getPSDynaWFId();
            node.setAttribute(FIELD_PSDYNAWFID, obj == null ? "" : obj);
        }
        if (bIncEmpty || et.getPSDynaWFName() != null) {
            obj = et.getPSDynaWFName();
            node.setAttribute(FIELD_PSDYNAWFNAME, obj == null ? "" : obj);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaWFVerBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PSDynaWFVerBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isPSDynaWFVerIdDirty() && (bIncEmpty || et.getPSDynaWFVerId() != null)) {
            dst.set(FIELD_PSDYNAWFVERID, (Object)et.getPSDynaWFVerId());
        }
        if (et.isPSDynaWFVerNameDirty() && (bIncEmpty || et.getPSDynaWFVerName() != null)) {
            dst.set(FIELD_PSDYNAWFVERNAME, (Object)et.getPSDynaWFVerName());
        }
        if (et.isPSDynaWFIdDirty() && (bIncEmpty || et.getPSDynaWFId() != null)) {
            dst.set(FIELD_PSDYNAWFID, (Object)et.getPSDynaWFId());
        }
        if (et.isPSDynaWFNameDirty() && (bIncEmpty || et.getPSDynaWFName() != null)) {
            dst.set(FIELD_PSDYNAWFNAME, (Object)et.getPSDynaWFName());
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
        return PSDynaWFVerBase.remove(this, index);
    }

    private static boolean remove(PSDynaWFVerBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetPSDynaWFVerId();
                return true;
            }
            case 1: {
                et.resetPSDynaWFVerName();
                return true;
            }
            case 2: {
                et.resetPSDynaWFId();
                return true;
            }
            case 3: {
                et.resetPSDynaWFName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDynaWFVerBase getProxyEntity() {
        return this.proxyPSDynaWFVerBase;
    }

    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaWFVerBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PSDynaWFVer) {
            this.proxyPSDynaWFVerBase = (PSDynaWFVer)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }
}

