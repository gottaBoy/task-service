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
package net.ibizsys.pscore.srv.liteutil.entity;

import java.io.Serializable;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppViewLiteBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppViewLiteBase.class);
    public static final String FIELD_PSAPPMODULEID = "PSAPPMODULEID";
    public static final String FIELD_PSAPPVIEWID = "PSAPPVIEWID";
    public static final String FIELD_PSAPPVIEWNAME = "PSAPPVIEWNAME";
    public static final String FIELD_PSAPPVIEWTYPE = "PSAPPVIEWTYPE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    private static final int INDEX_PSAPPMODULEID = 0;
    private static final int INDEX_PSAPPVIEWID = 1;
    private static final int INDEX_PSAPPVIEWNAME = 2;
    private static final int INDEX_PSAPPVIEWTYPE = 3;
    private static final int INDEX_PSDEID = 4;
    private static final int INDEX_PSDENAME = 5;
    private static final int INDEX_PSDEVIEWBASEID = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppViewLiteBase proxyPSAppViewLiteBase = null;
    private boolean psappmoduleidDirtyFlag = false;
    private boolean psappviewidDirtyFlag = false;
    private boolean psappviewnameDirtyFlag = false;
    private boolean psappviewtypeDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    @Column(name="psappmoduleid")
    private String psappmoduleid;
    @Column(name="psappviewid")
    private String psappviewid;
    @Column(name="psappviewname")
    private String psappviewname;
    @Column(name="psappviewtype")
    private String psappviewtype;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="pssysappid")
    private String pssysappid;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;

    public void setPSAppModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappmoduleid = string;
        this.psappmoduleidDirtyFlag = true;
    }

    public String getPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppModuleId();
        }
        return this.psappmoduleid;
    }

    public boolean isPSAppModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppModuleIdDirty();
        }
        return this.psappmoduleidDirtyFlag;
    }

    public void resetPSAppModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppModuleId();
            return;
        }
        this.psappmoduleidDirtyFlag = false;
        this.psappmoduleid = null;
    }

    public void setPSAppViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewid = string;
        this.psappviewidDirtyFlag = true;
    }

    public String getPSAppViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewId();
        }
        return this.psappviewid;
    }

    public boolean isPSAppViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewIdDirty();
        }
        return this.psappviewidDirtyFlag;
    }

    public void resetPSAppViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewId();
            return;
        }
        this.psappviewidDirtyFlag = false;
        this.psappviewid = null;
    }

    public void setPSAppViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewname = string;
        this.psappviewnameDirtyFlag = true;
    }

    public String getPSAppViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewName();
        }
        return this.psappviewname;
    }

    public boolean isPSAppViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewNameDirty();
        }
        return this.psappviewnameDirtyFlag;
    }

    public void resetPSAppViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewName();
            return;
        }
        this.psappviewnameDirtyFlag = false;
        this.psappviewname = null;
    }

    public void setPSAppViewType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppViewType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappviewtype = string;
        this.psappviewtypeDirtyFlag = true;
    }

    public String getPSAppViewType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppViewType();
        }
        return this.psappviewtype;
    }

    public boolean isPSAppViewTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppViewTypeDirty();
        }
        return this.psappviewtypeDirtyFlag;
    }

    public void resetPSAppViewType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppViewType();
            return;
        }
        this.psappviewtypeDirtyFlag = false;
        this.psappviewtype = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    protected void onReset() {
        PSAppViewLiteBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppViewLiteBase pSAppViewLiteBase) {
        pSAppViewLiteBase.resetPSAppModuleId();
        pSAppViewLiteBase.resetPSAppViewId();
        pSAppViewLiteBase.resetPSAppViewName();
        pSAppViewLiteBase.resetPSAppViewType();
        pSAppViewLiteBase.resetPSDEId();
        pSAppViewLiteBase.resetPSDEName();
        pSAppViewLiteBase.resetPSDEViewBaseId();
        pSAppViewLiteBase.resetPSSysAppId();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isPSAppModuleIdDirty()) {
            hashMap.put(FIELD_PSAPPMODULEID, this.getPSAppModuleId());
        }
        if (!bl || this.isPSAppViewIdDirty()) {
            hashMap.put(FIELD_PSAPPVIEWID, this.getPSAppViewId());
        }
        if (!bl || this.isPSAppViewNameDirty()) {
            hashMap.put(FIELD_PSAPPVIEWNAME, this.getPSAppViewName());
        }
        if (!bl || this.isPSAppViewTypeDirty()) {
            hashMap.put(FIELD_PSAPPVIEWTYPE, this.getPSAppViewType());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
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
        return PSAppViewLiteBase.get(this, n);
    }

    private static Object get(PSAppViewLiteBase pSAppViewLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLiteBase.getPSAppModuleId();
            }
            case 1: {
                return pSAppViewLiteBase.getPSAppViewId();
            }
            case 2: {
                return pSAppViewLiteBase.getPSAppViewName();
            }
            case 3: {
                return pSAppViewLiteBase.getPSAppViewType();
            }
            case 4: {
                return pSAppViewLiteBase.getPSDEId();
            }
            case 5: {
                return pSAppViewLiteBase.getPSDEName();
            }
            case 6: {
                return pSAppViewLiteBase.getPSDEViewBaseId();
            }
            case 7: {
                return pSAppViewLiteBase.getPSSysAppId();
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
        PSAppViewLiteBase.set(this, n, object);
    }

    private static void set(PSAppViewLiteBase pSAppViewLiteBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewLiteBase.setPSAppModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSAppViewLiteBase.setPSAppViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppViewLiteBase.setPSAppViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppViewLiteBase.setPSAppViewType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppViewLiteBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppViewLiteBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppViewLiteBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppViewLiteBase.setPSSysAppId(DataObject.getStringValue((Object)object));
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
        return PSAppViewLiteBase.isNull(this, n);
    }

    private static boolean isNull(PSAppViewLiteBase pSAppViewLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLiteBase.getPSAppModuleId() == null;
            }
            case 1: {
                return pSAppViewLiteBase.getPSAppViewId() == null;
            }
            case 2: {
                return pSAppViewLiteBase.getPSAppViewName() == null;
            }
            case 3: {
                return pSAppViewLiteBase.getPSAppViewType() == null;
            }
            case 4: {
                return pSAppViewLiteBase.getPSDEId() == null;
            }
            case 5: {
                return pSAppViewLiteBase.getPSDEName() == null;
            }
            case 6: {
                return pSAppViewLiteBase.getPSDEViewBaseId() == null;
            }
            case 7: {
                return pSAppViewLiteBase.getPSSysAppId() == null;
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
        return PSAppViewLiteBase.contains(this, n);
    }

    private static boolean contains(PSAppViewLiteBase pSAppViewLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppViewLiteBase.isPSAppModuleIdDirty();
            }
            case 1: {
                return pSAppViewLiteBase.isPSAppViewIdDirty();
            }
            case 2: {
                return pSAppViewLiteBase.isPSAppViewNameDirty();
            }
            case 3: {
                return pSAppViewLiteBase.isPSAppViewTypeDirty();
            }
            case 4: {
                return pSAppViewLiteBase.isPSDEIdDirty();
            }
            case 5: {
                return pSAppViewLiteBase.isPSDENameDirty();
            }
            case 6: {
                return pSAppViewLiteBase.isPSDEViewBaseIdDirty();
            }
            case 7: {
                return pSAppViewLiteBase.isPSSysAppIdDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppViewLiteBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppViewLiteBase pSAppViewLiteBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppViewLiteBase.getPSAppModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappmoduleid", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSAppModuleId()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewid", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSAppViewId()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewname", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSAppViewName()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappviewtype", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSAppViewType()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSAppViewLiteBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppViewLiteBase.getJSONValue((Object)pSAppViewLiteBase.getPSSysAppId()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppViewLiteBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppViewLiteBase pSAppViewLiteBase, XmlNode xmlNode, boolean bl) throws Exception {
        String string;
        if (bl || pSAppViewLiteBase.getPSAppModuleId() != null) {
            string = pSAppViewLiteBase.getPSAppModuleId();
            xmlNode.setAttribute(FIELD_PSAPPMODULEID, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewId() != null) {
            string = pSAppViewLiteBase.getPSAppViewId();
            xmlNode.setAttribute(FIELD_PSAPPVIEWID, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewName() != null) {
            string = pSAppViewLiteBase.getPSAppViewName();
            xmlNode.setAttribute(FIELD_PSAPPVIEWNAME, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSAppViewType() != null) {
            string = pSAppViewLiteBase.getPSAppViewType();
            xmlNode.setAttribute(FIELD_PSAPPVIEWTYPE, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSDEId() != null) {
            string = pSAppViewLiteBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSDEName() != null) {
            string = pSAppViewLiteBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSDEViewBaseId() != null) {
            string = pSAppViewLiteBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, string == null ? "" : string);
        }
        if (bl || pSAppViewLiteBase.getPSSysAppId() != null) {
            string = pSAppViewLiteBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, string == null ? "" : string);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppViewLiteBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppViewLiteBase pSAppViewLiteBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppViewLiteBase.isPSAppModuleIdDirty() && (bl || pSAppViewLiteBase.getPSAppModuleId() != null)) {
            iDataObject.set(FIELD_PSAPPMODULEID, (Object)pSAppViewLiteBase.getPSAppModuleId());
        }
        if (pSAppViewLiteBase.isPSAppViewIdDirty() && (bl || pSAppViewLiteBase.getPSAppViewId() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWID, (Object)pSAppViewLiteBase.getPSAppViewId());
        }
        if (pSAppViewLiteBase.isPSAppViewNameDirty() && (bl || pSAppViewLiteBase.getPSAppViewName() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWNAME, (Object)pSAppViewLiteBase.getPSAppViewName());
        }
        if (pSAppViewLiteBase.isPSAppViewTypeDirty() && (bl || pSAppViewLiteBase.getPSAppViewType() != null)) {
            iDataObject.set(FIELD_PSAPPVIEWTYPE, (Object)pSAppViewLiteBase.getPSAppViewType());
        }
        if (pSAppViewLiteBase.isPSDEIdDirty() && (bl || pSAppViewLiteBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSAppViewLiteBase.getPSDEId());
        }
        if (pSAppViewLiteBase.isPSDENameDirty() && (bl || pSAppViewLiteBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSAppViewLiteBase.getPSDEName());
        }
        if (pSAppViewLiteBase.isPSDEViewBaseIdDirty() && (bl || pSAppViewLiteBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSAppViewLiteBase.getPSDEViewBaseId());
        }
        if (pSAppViewLiteBase.isPSSysAppIdDirty() && (bl || pSAppViewLiteBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppViewLiteBase.getPSSysAppId());
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
        return PSAppViewLiteBase.remove(this, n);
    }

    private static boolean remove(PSAppViewLiteBase pSAppViewLiteBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppViewLiteBase.resetPSAppModuleId();
                return true;
            }
            case 1: {
                pSAppViewLiteBase.resetPSAppViewId();
                return true;
            }
            case 2: {
                pSAppViewLiteBase.resetPSAppViewName();
                return true;
            }
            case 3: {
                pSAppViewLiteBase.resetPSAppViewType();
                return true;
            }
            case 4: {
                pSAppViewLiteBase.resetPSDEId();
                return true;
            }
            case 5: {
                pSAppViewLiteBase.resetPSDEName();
                return true;
            }
            case 6: {
                pSAppViewLiteBase.resetPSDEViewBaseId();
                return true;
            }
            case 7: {
                pSAppViewLiteBase.resetPSSysAppId();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
    }

    private PSAppViewLiteBase getProxyEntity() {
        return this.proxyPSAppViewLiteBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppViewLiteBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppViewLiteBase) {
            this.proxyPSAppViewLiteBase = (PSAppViewLiteBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.liteutil.service.PSAppViewLiteService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_PSAPPMODULEID, 0);
        fieldIndexMap.put(FIELD_PSAPPVIEWID, 1);
        fieldIndexMap.put(FIELD_PSAPPVIEWNAME, 2);
        fieldIndexMap.put(FIELD_PSAPPVIEWTYPE, 3);
        fieldIndexMap.put(FIELD_PSDEID, 4);
        fieldIndexMap.put(FIELD_PSDENAME, 5);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
    }
}

