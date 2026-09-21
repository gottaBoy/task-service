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
import net.ibizsys.paas.sysmodel.util.dynaclient.entity.PSDynaAppViewInst;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSDynaAppViewInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaAppViewInstBase.class);
    public static final String FIELD_PSDYNAAPPVIEWINSTID = "PSDYNAAPPVIEWINSTID";
    public static final String FIELD_PSDYNAAPPVIEWINSTNAME = "PSDYNAAPPVIEWINSTNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PREDEFINEDVIEWTYPE = "PREDEFINEDVIEWTYPE";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_PDVTPARAM = "PDVTPARAM";
    public static final String FIELD_PSDYNAAPPVIEWID = "PSDYNAAPPVIEWID";
    private static final int INDEX_PSDYNAAPPVIEWINSTID = 0;
    private static final int INDEX_PSDYNAAPPVIEWINSTNAME = 1;
    private static final int INDEX_PSDYNAINSTID = 2;
    private static final int INDEX_PREDEFINEDVIEWTYPE = 3;
    private static final int INDEX_INSTVER = 4;
    private static final int INDEX_DYNAMODEL = 5;
    private static final int INDEX_PDVTPARAM = 6;
    private static final int INDEX_PSDYNAAPPVIEWID = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaAppViewInstBase proxyPSDynaAppViewInstBase = null;
    private boolean psdynaappviewinstidDirtyFlag = false;
    private boolean psdynaappviewinstnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean predefinedviewtypeDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean pdvtparamDirtyFlag = false;
    private boolean psdynaappviewidDirtyFlag = false;
    @Column(name="psdynaappviewinstid")
    private String psdynaappviewinstid;
    @Column(name="psdynaappviewinstname")
    private String psdynaappviewinstname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="predefinedviewtype")
    private String predefinedviewtype;
    @Column(name="instver")
    private Integer instver;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="pdvtparam")
    private String pdvtparam;
    @Column(name="psdynaappviewid")
    private String psdynaappviewid;

    static {
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTID, 0);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWINSTNAME, 1);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 2);
        fieldIndexMap.put(FIELD_PREDEFINEDVIEWTYPE, 3);
        fieldIndexMap.put(FIELD_INSTVER, 4);
        fieldIndexMap.put(FIELD_DYNAMODEL, 5);
        fieldIndexMap.put(FIELD_PDVTPARAM, 6);
        fieldIndexMap.put(FIELD_PSDYNAAPPVIEWID, 7);
    }

    public void setPSDynaAppViewInstId(String psdynaappviewinstid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstId(psdynaappviewinstid);
            return;
        }
        if (psdynaappviewinstid != null && (psdynaappviewinstid = StringHelper.trimRight((String)psdynaappviewinstid)).length() == 0) {
            psdynaappviewinstid = null;
        }
        this.psdynaappviewinstid = psdynaappviewinstid;
        this.psdynaappviewinstidDirtyFlag = true;
    }

    public String getPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstId();
        }
        return this.psdynaappviewinstid;
    }

    public boolean isPSDynaAppViewInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstIdDirty();
        }
        return this.psdynaappviewinstidDirtyFlag;
    }

    public void resetPSDynaAppViewInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstId();
            return;
        }
        this.psdynaappviewinstidDirtyFlag = false;
        this.psdynaappviewinstid = null;
    }

    public void setPSDynaAppViewInstName(String psdynaappviewinstname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewInstName(psdynaappviewinstname);
            return;
        }
        if (psdynaappviewinstname != null && (psdynaappviewinstname = StringHelper.trimRight((String)psdynaappviewinstname)).length() == 0) {
            psdynaappviewinstname = null;
        }
        this.psdynaappviewinstname = psdynaappviewinstname;
        this.psdynaappviewinstnameDirtyFlag = true;
    }

    public String getPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewInstName();
        }
        return this.psdynaappviewinstname;
    }

    public boolean isPSDynaAppViewInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewInstNameDirty();
        }
        return this.psdynaappviewinstnameDirtyFlag;
    }

    public void resetPSDynaAppViewInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewInstName();
            return;
        }
        this.psdynaappviewinstnameDirtyFlag = false;
        this.psdynaappviewinstname = null;
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

    public void setPredefinedViewType(String predefinedviewtype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedViewType(predefinedviewtype);
            return;
        }
        if (predefinedviewtype != null && (predefinedviewtype = StringHelper.trimRight((String)predefinedviewtype)).length() == 0) {
            predefinedviewtype = null;
        }
        this.predefinedviewtype = predefinedviewtype;
        this.predefinedviewtypeDirtyFlag = true;
    }

    public String getPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedViewType();
        }
        return this.predefinedviewtype;
    }

    public boolean isPredefinedViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedViewTypeDirty();
        }
        return this.predefinedviewtypeDirtyFlag;
    }

    public void resetPredefinedViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedViewType();
            return;
        }
        this.predefinedviewtypeDirtyFlag = false;
        this.predefinedviewtype = null;
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

    public void setPDVTParam(String pdvtparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPDVTParam(pdvtparam);
            return;
        }
        if (pdvtparam != null && (pdvtparam = StringHelper.trimRight((String)pdvtparam)).length() == 0) {
            pdvtparam = null;
        }
        this.pdvtparam = pdvtparam;
        this.pdvtparamDirtyFlag = true;
    }

    public String getPDVTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPDVTParam();
        }
        return this.pdvtparam;
    }

    public boolean isPDVTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPDVTParamDirty();
        }
        return this.pdvtparamDirtyFlag;
    }

    public void resetPDVTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPDVTParam();
            return;
        }
        this.pdvtparamDirtyFlag = false;
        this.pdvtparam = null;
    }

    public void setPSDynaAppViewId(String psdynaappviewid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaAppViewId(psdynaappviewid);
            return;
        }
        if (psdynaappviewid != null && (psdynaappviewid = StringHelper.trimRight((String)psdynaappviewid)).length() == 0) {
            psdynaappviewid = null;
        }
        this.psdynaappviewid = psdynaappviewid;
        this.psdynaappviewidDirtyFlag = true;
    }

    public String getPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaAppViewId();
        }
        return this.psdynaappviewid;
    }

    public boolean isPSDynaAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaAppViewIdDirty();
        }
        return this.psdynaappviewidDirtyFlag;
    }

    public void resetPSDynaAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaAppViewId();
            return;
        }
        this.psdynaappviewidDirtyFlag = false;
        this.psdynaappviewid = null;
    }

    protected void onReset() {
        PSDynaAppViewInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaAppViewInstBase et) {
        et.resetPSDynaAppViewInstId();
        et.resetPSDynaAppViewInstName();
        et.resetPSDynaInstId();
        et.resetPredefinedViewType();
        et.resetInstVer();
        et.resetDynaModel();
        et.resetPDVTParam();
        et.resetPSDynaAppViewId();
    }

    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isPSDynaAppViewInstIdDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWINSTID, this.getPSDynaAppViewInstId());
        }
        if (!bDirtyOnly || this.isPSDynaAppViewInstNameDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWINSTNAME, this.getPSDynaAppViewInstName());
        }
        if (!bDirtyOnly || this.isPSDynaInstIdDirty()) {
            params.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bDirtyOnly || this.isPredefinedViewTypeDirty()) {
            params.put(FIELD_PREDEFINEDVIEWTYPE, this.getPredefinedViewType());
        }
        if (!bDirtyOnly || this.isInstVerDirty()) {
            params.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bDirtyOnly || this.isDynaModelDirty()) {
            params.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bDirtyOnly || this.isPDVTParamDirty()) {
            params.put(FIELD_PDVTPARAM, this.getPDVTParam());
        }
        if (!bDirtyOnly || this.isPSDynaAppViewIdDirty()) {
            params.put(FIELD_PSDYNAAPPVIEWID, this.getPSDynaAppViewId());
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
        return PSDynaAppViewInstBase.get(this, index);
    }

    private static Object get(PSDynaAppViewInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaAppViewInstId();
            }
            case 1: {
                return et.getPSDynaAppViewInstName();
            }
            case 2: {
                return et.getPSDynaInstId();
            }
            case 3: {
                return et.getPredefinedViewType();
            }
            case 4: {
                return et.getInstVer();
            }
            case 5: {
                return et.getDynaModel();
            }
            case 6: {
                return et.getPDVTParam();
            }
            case 7: {
                return et.getPSDynaAppViewId();
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
        PSDynaAppViewInstBase.set(this, index, objValue);
    }

    private static void set(PSDynaAppViewInstBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setPSDynaAppViewInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 1: {
                et.setPSDynaAppViewInstName(DataObject.getStringValue((Object)obj));
                return;
            }
            case 2: {
                et.setPSDynaInstId(DataObject.getStringValue((Object)obj));
                return;
            }
            case 3: {
                et.setPredefinedViewType(DataObject.getStringValue((Object)obj));
                return;
            }
            case 4: {
                et.setInstVer(DataObject.getIntegerValue((Object)obj));
                return;
            }
            case 5: {
                et.setDynaModel(DataObject.getStringValue((Object)obj));
                return;
            }
            case 6: {
                et.setPDVTParam(DataObject.getStringValue((Object)obj));
                return;
            }
            case 7: {
                et.setPSDynaAppViewId(DataObject.getStringValue((Object)obj));
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
        return PSDynaAppViewInstBase.isNull(this, index);
    }

    private static boolean isNull(PSDynaAppViewInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getPSDynaAppViewInstId() == null;
            }
            case 1: {
                return et.getPSDynaAppViewInstName() == null;
            }
            case 2: {
                return et.getPSDynaInstId() == null;
            }
            case 3: {
                return et.getPredefinedViewType() == null;
            }
            case 4: {
                return et.getInstVer() == null;
            }
            case 5: {
                return et.getDynaModel() == null;
            }
            case 6: {
                return et.getPDVTParam() == null;
            }
            case 7: {
                return et.getPSDynaAppViewId() == null;
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
        return PSDynaAppViewInstBase.contains(this, index);
    }

    private static boolean contains(PSDynaAppViewInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isPSDynaAppViewInstIdDirty();
            }
            case 1: {
                return et.isPSDynaAppViewInstNameDirty();
            }
            case 2: {
                return et.isPSDynaInstIdDirty();
            }
            case 3: {
                return et.isPredefinedViewTypeDirty();
            }
            case 4: {
                return et.isInstVerDirty();
            }
            case 5: {
                return et.isDynaModelDirty();
            }
            case 6: {
                return et.isPDVTParamDirty();
            }
            case 7: {
                return et.isPSDynaAppViewIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        PSDynaAppViewInstBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(PSDynaAppViewInstBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getPSDynaAppViewInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynaappviewinstid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPSDynaAppViewInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaAppViewInstName() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynaappviewinstname", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPSDynaAppViewInstName()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynainstid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPSDynaInstId()), (boolean)false);
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"predefinedviewtype", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPredefinedViewType()), (boolean)false);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"instver", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getInstVer()), (boolean)false);
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"dynamodel", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getDynaModel()), (boolean)false);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"pdvtparam", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPDVTParam()), (boolean)false);
        }
        if (bIncEmpty || et.getPSDynaAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)json, (String)"psdynaappviewid", (Object)PSDynaAppViewInstBase.getJSONValue((Object)et.getPSDynaAppViewId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        PSDynaAppViewInstBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(PSDynaAppViewInstBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getPSDynaAppViewInstId() != null) {
            obj = et.getPSDynaAppViewInstId();
            node.setAttribute(FIELD_PSDYNAAPPVIEWINSTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPSDynaAppViewInstName() != null) {
            obj = et.getPSDynaAppViewInstName();
            node.setAttribute(FIELD_PSDYNAAPPVIEWINSTNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPSDynaInstId() != null) {
            obj = et.getPSDynaInstId();
            node.setAttribute(FIELD_PSDYNAINSTID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getPredefinedViewType() != null) {
            obj = et.getPredefinedViewType();
            node.setAttribute(FIELD_PREDEFINEDVIEWTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getInstVer() != null) {
            obj = et.getInstVer();
            node.setAttribute(FIELD_INSTVER, obj == null ? "" : StringHelper.format((String)"%1$s", (Object)obj));
        }
        if (bIncEmpty || et.getDynaModel() != null) {
            obj = et.getDynaModel();
            node.setAttribute(FIELD_DYNAMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPDVTParam() != null) {
            obj = et.getPDVTParam();
            node.setAttribute(FIELD_PDVTPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPSDynaAppViewId() != null) {
            obj = et.getPSDynaAppViewId();
            node.setAttribute(FIELD_PSDYNAAPPVIEWID, obj == null ? "" : (String)obj);
        }
    }

    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        PSDynaAppViewInstBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(PSDynaAppViewInstBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isPSDynaAppViewInstIdDirty() && (bIncEmpty || et.getPSDynaAppViewInstId() != null)) {
            dst.set(FIELD_PSDYNAAPPVIEWINSTID, (Object)et.getPSDynaAppViewInstId());
        }
        if (et.isPSDynaAppViewInstNameDirty() && (bIncEmpty || et.getPSDynaAppViewInstName() != null)) {
            dst.set(FIELD_PSDYNAAPPVIEWINSTNAME, (Object)et.getPSDynaAppViewInstName());
        }
        if (et.isPSDynaInstIdDirty() && (bIncEmpty || et.getPSDynaInstId() != null)) {
            dst.set(FIELD_PSDYNAINSTID, (Object)et.getPSDynaInstId());
        }
        if (et.isPredefinedViewTypeDirty() && (bIncEmpty || et.getPredefinedViewType() != null)) {
            dst.set(FIELD_PREDEFINEDVIEWTYPE, (Object)et.getPredefinedViewType());
        }
        if (et.isInstVerDirty() && (bIncEmpty || et.getInstVer() != null)) {
            dst.set(FIELD_INSTVER, (Object)et.getInstVer());
        }
        if (et.isDynaModelDirty() && (bIncEmpty || et.getDynaModel() != null)) {
            dst.set(FIELD_DYNAMODEL, (Object)et.getDynaModel());
        }
        if (et.isPDVTParamDirty() && (bIncEmpty || et.getPDVTParam() != null)) {
            dst.set(FIELD_PDVTPARAM, (Object)et.getPDVTParam());
        }
        if (et.isPSDynaAppViewIdDirty() && (bIncEmpty || et.getPSDynaAppViewId() != null)) {
            dst.set(FIELD_PSDYNAAPPVIEWID, (Object)et.getPSDynaAppViewId());
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
        return PSDynaAppViewInstBase.remove(this, index);
    }

    private static boolean remove(PSDynaAppViewInstBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetPSDynaAppViewInstId();
                return true;
            }
            case 1: {
                et.resetPSDynaAppViewInstName();
                return true;
            }
            case 2: {
                et.resetPSDynaInstId();
                return true;
            }
            case 3: {
                et.resetPredefinedViewType();
                return true;
            }
            case 4: {
                et.resetInstVer();
                return true;
            }
            case 5: {
                et.resetDynaModel();
                return true;
            }
            case 6: {
                et.resetPDVTParam();
                return true;
            }
            case 7: {
                et.resetPSDynaAppViewId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDynaAppViewInstBase getProxyEntity() {
        return this.proxyPSDynaAppViewInstBase;
    }

    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyPSDynaAppViewInstBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof PSDynaAppViewInst) {
            this.proxyPSDynaAppViewInstBase = (PSDynaAppViewInst)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }
}

