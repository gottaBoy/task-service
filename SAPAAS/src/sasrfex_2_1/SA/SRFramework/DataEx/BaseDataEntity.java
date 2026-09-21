/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DBCallerConfig
 *  SA.SRFramework.Data.DBCallerParam
 *  SA.SRFramework.Data.DataColumn
 *  SA.SRFramework.Data.DataRow
 *  SA.SRFramework.Data.DataTable
 *  SA.SRFramework.Data.DataTypeParse
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DBCallerConfig;
import SA.SRFramework.Data.DBCallerParam;
import SA.SRFramework.Data.DataColumn;
import SA.SRFramework.Data.DataRow;
import SA.SRFramework.Data.DataTable;
import SA.SRFramework.Data.DataTypeParse;
import SA.SRFramework.DataEx.BaseDataEntities;
import SA.SRFramework.DataEx.DataEntityConfig;
import SA.SRFramework.DataEx.DataEntityItemConfig;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExWebContext;
import SA.SRFramework.XML.XmlWriter;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseDataEntity
implements Serializable {
    private Hashtable paramList = null;
    private Hashtable nullParamList = null;
    private BaseDataEntity proxyDataEntity = null;
    private static final Log log = LogFactory.getLog(BaseDataEntity.class);

    public void proxy(BaseDataEntity proxyDataEntity) {
        this.Proxy(proxyDataEntity);
    }

    public void Proxy(BaseDataEntity proxyDataEntity) {
        this.proxyDataEntity = proxyDataEntity;
    }

    public final void Reset() {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.Reset();
        } else {
            if (this.paramList != null) {
                this.paramList.clear();
            }
            if (this.nullParamList != null) {
                this.nullParamList.clear();
            }
            this.OnReset();
        }
    }

    protected void OnReset() {
    }

    public final boolean FromDataRow(DataRow dr) throws Exception {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.FromDataRow(dr);
        }
        if (dr == null) {
            return false;
        }
        DataTable dataTable = dr.getDataTable();
        if (dataTable != null) {
            int nColumnCount = dataTable.GetColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                DataColumn dataColumn = dataTable.GetDataColumn(i);
                if (dr.IsDBNull(i)) {
                    this.SetParamValue(dataColumn.getName(), null);
                } else {
                    this.SetParamValue(dataColumn.getName(), dr.Get(i));
                }
                ++i;
            }
        }
        return this.OnFromDataRow(dr);
    }

    public final boolean FromMap(Map map) throws Exception {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.FromMap(map);
        }
        this.Reset();
        if (map == null) {
            return false;
        }
        for (Object objKey : map.keySet()) {
            Object objValue = map.get(objKey);
            if (objValue == null) continue;
            if (objValue instanceof String && StringHelper.IsNullOrEmpty((String)objValue.toString())) {
                this.SetParamValue(objKey.toString(), null);
                continue;
            }
            this.SetParamValue(objKey.toString(), objValue);
        }
        return this.OnFromMap(map);
    }

    protected boolean OnFromMap(Map map) throws Exception {
        return true;
    }

    public void FillMap(Map map) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.FillMap(map);
        } else {
            Object objKey;
            Enumeration keys;
            if (this.paramList != null) {
                keys = this.paramList.keys();
                while (keys.hasMoreElements()) {
                    objKey = keys.nextElement();
                    Object objValue = this.paramList.get(objKey);
                    map.put(objKey, objValue);
                }
            }
            if (this.nullParamList != null) {
                keys = this.nullParamList.keys();
                while (keys.hasMoreElements()) {
                    objKey = keys.nextElement();
                    map.put(objKey, "");
                }
            }
        }
    }

    public final boolean FromDataRow(DataRow dr, boolean bReset) throws Exception {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.FromDataRow(dr, bReset);
        }
        if (bReset) {
            this.Reset();
        }
        return this.FromDataRow(dr);
    }

    public static final BaseDataEntity FromJSONString(String strJSONString) {
        JSONObject jsonObject = JSONObject.fromString((String)strJSONString);
        return BaseDataEntity.FromJSONObject(jsonObject);
    }

    public static final BaseDataEntity FromJSONObject(JSONObject jsonObject) {
        BaseDataEntity baseDataEntity = new BaseDataEntity();
        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            Object objKey = it.next();
            Object objValue = jsonObject.get(objKey.toString());
            if (objValue instanceof JSONNull) {
                baseDataEntity.SetParamValue(objKey.toString(), null);
                continue;
            }
            if (objValue instanceof JSONArray) {
                baseDataEntity.SetParamValue(objKey.toString(), BaseDataEntities.FromJSONArray((JSONArray)objValue));
                continue;
            }
            if (objValue instanceof JSONObject) {
                JSONObject jo = (JSONObject)objValue;
                if (jo.has("time")) {
                    long lTime = jo.getLong("time");
                    Timestamp date = new Timestamp(lTime);
                    baseDataEntity.SetParamValue(objKey.toString(), date);
                    continue;
                }
                baseDataEntity.SetParamValue(objKey.toString(), jo.toString());
                continue;
            }
            baseDataEntity.SetParamValue(objKey.toString(), objValue);
        }
        return baseDataEntity;
    }

    public static final BaseDataEntity FromJSONObject(BaseDataEntity baseDataEntity, JSONObject jsonObject) {
        if (baseDataEntity == null) {
            baseDataEntity = new BaseDataEntity();
        }
        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            Object objKey = it.next();
            Object objValue = jsonObject.get(objKey.toString());
            if (objValue instanceof JSONNull) {
                baseDataEntity.SetParamValue(objKey.toString(), null);
                continue;
            }
            if (objValue instanceof JSONArray) {
                baseDataEntity.SetParamValue(objKey.toString(), BaseDataEntities.FromJSONArray((JSONArray)objValue));
                continue;
            }
            baseDataEntity.SetParamValue(objKey.toString(), objValue);
        }
        return baseDataEntity;
    }

    public final boolean From(SRFExWebContext webContext, DataEntityConfig dataEntityConfig) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.From(webContext, dataEntityConfig);
        }
        this.Reset();
        boolean bRet = true;
        for (Object objParam : dataEntityConfig.getList()) {
            DataEntityItemConfig param = (DataEntityItemConfig)((Object)objParam);
            String strParamName = param.getDBField();
            String strParamValue = webContext.GetParamValue(strParamName);
            if (StringHelper.Length((String)strParamValue) == 0) {
                strParamValue = webContext.getPage().getRequest().getParameter(strParamName.toLowerCase());
            }
            if (StringHelper.Length((String)strParamValue) == 0) continue;
            Object objValue = DataTypeParse.Parse((int)param.getDataType(), (String)strParamValue);
            if (objValue == null) {
                bRet = false;
                continue;
            }
            this.SetParamValue(strParamName, objValue);
        }
        return bRet;
    }

    public final boolean From(SRFExWebContext webContext, DBCallerConfig searchCallConfig) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.From(webContext, searchCallConfig);
        }
        this.Reset();
        boolean bRet = true;
        for (Object objParam : searchCallConfig.getParams()) {
            String strParamValue;
            DBCallerParam param = (DBCallerParam)objParam;
            String strParamName = param.getParamName();
            if (StringHelper.Length((String)strParamName) == 0) {
                strParamName = param.getParamValue();
            }
            if (StringHelper.Length((String)(strParamValue = webContext.GetParamValue(strParamName))) == 0) {
                strParamValue = webContext.getPage().getRequest().getParameter(strParamName.toLowerCase());
            }
            if (StringHelper.Length((String)strParamValue) == 0) continue;
            Object objValue = DataTypeParse.Parse((int)param.getDBType(), (String)strParamValue);
            if (objValue == null) {
                bRet = false;
                continue;
            }
            this.SetParamValue(strParamName, objValue);
        }
        return bRet;
    }

    protected boolean OnFromDataRow(DataRow dr) {
        return true;
    }

    public void FillHashtable(Hashtable hashtable) {
    }

    public final Hashtable getParamList() {
        return this.getParamList(true);
    }

    public final Hashtable getParamList(boolean bCreate) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.getParamList(bCreate);
        }
        if (this.paramList == null && bCreate) {
            this.paramList = new Hashtable();
        }
        if (this.paramList != null) {
            this.OnFillParamList();
        }
        return this.paramList;
    }

    protected void OnFillParamList() {
    }

    public final Hashtable getNullParamList(boolean bCreate) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.getNullParamList(bCreate);
        }
        if (this.nullParamList == null && bCreate) {
            this.nullParamList = new Hashtable();
        }
        if (this.nullParamList != null) {
            this.OnFillNullParamList();
        }
        return this.nullParamList;
    }

    public final Hashtable getNullParamList() {
        return this.getNullParamList(true);
    }

    protected void OnFillNullParamList() {
    }

    public final Hashtable getTotalParamList() {
        return this.getTotalParamList(null);
    }

    public final Hashtable getTotalParamList(Hashtable totalParamList) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.getTotalParamList();
        }
        if (totalParamList == null) {
            totalParamList = new Hashtable();
        }
        if (this.paramList != null) {
            totalParamList.putAll(this.paramList);
        }
        if (this.nullParamList != null) {
            totalParamList.putAll(this.nullParamList);
        }
        return totalParamList;
    }

    public final boolean ContainesParam(String strParamName) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.ContainesParam(strParamName);
        }
        if (strParamName == null) {
            return false;
        }
        strParamName = strParamName.toUpperCase();
        if (this.paramList != null && this.paramList.containsKey(strParamName)) {
            return true;
        }
        return this.nullParamList != null && this.nullParamList.containsKey(strParamName);
    }

    public boolean IsParamNull(String strParamName) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.IsParamNull(strParamName);
        }
        return this.paramList == null || !this.paramList.containsKey(strParamName = strParamName.toUpperCase());
    }

    public final void RemoveParams(String strParamName) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.RemoveParams(strParamName);
        } else {
            String[] params = StringHelper.SplitEx((String)strParamName);
            if (params == null) {
                return;
            }
            int i = 0;
            while (i < params.length) {
                this.RemoveParam(params[i]);
                ++i;
            }
        }
    }

    public final void RemoveParam(String strParamName) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.RemoveParam(strParamName);
        } else {
            if (StringHelper.Length((String)strParamName) == 0) {
                return;
            }
            strParamName = strParamName.toUpperCase();
            if (this.paramList != null && this.paramList.containsKey(strParamName)) {
                this.paramList.remove(strParamName);
            }
            if (this.nullParamList != null && this.nullParamList.containsKey(strParamName)) {
                this.nullParamList.remove(strParamName);
            }
        }
    }

    public Object getParamValue(String strParamName) {
        return this.GetParamValue(strParamName);
    }

    @Deprecated
    public Object GetParamValue(String strParamName) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamValue(strParamName);
        }
        String strParamName2 = strParamName.toUpperCase();
        if (this.paramList == null) {
            return null;
        }
        return this.paramList.get(strParamName2);
    }

    public final Object get(String strParamName) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.get(strParamName);
        }
        Object obj = this.GetParamValue(strParamName);
        if (obj == null) {
            return "";
        }
        return obj;
    }

    public final void set(String strParamName, Object objParamValue) {
        this.setParamValue(strParamName, objParamValue);
    }

    @Deprecated
    public final void SetParamValue(String strParamName, Object objParamValue) {
        this.setParamValue(strParamName, objParamValue);
    }

    public final void setParamValue(String strParamName, Object objParamValue) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.setParamValue(strParamName, objParamValue);
        } else {
            if (StringHelper.IsNullOrEmpty((String)strParamName)) {
                return;
            }
            strParamName = strParamName.toUpperCase();
            if (objParamValue == null) {
                if (this.nullParamList == null) {
                    this.nullParamList = new Hashtable();
                }
                this.nullParamList.put(strParamName, 0);
                if (this.paramList != null && this.paramList.containsKey(strParamName)) {
                    this.paramList.remove(strParamName);
                }
            } else {
                if (this.paramList == null) {
                    this.paramList = new Hashtable();
                }
                this.paramList.put(strParamName, objParamValue);
                if (this.nullParamList != null && this.nullParamList.containsKey(strParamName)) {
                    this.nullParamList.remove(strParamName);
                }
            }
        }
    }

    public final int GetParamIntValue(String strParamName, int nDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamIntValue(strParamName, nDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Integer) {
                return (Integer)objValue;
            }
            if (objValue instanceof Long) {
                return ((Long)objValue).intValue();
            }
            if (objValue instanceof Double) {
                return ((Double)objValue).intValue();
            }
            if (objValue instanceof BigDecimal) {
                return ((BigDecimal)objValue).intValue();
            }
            return Integer.parseInt(objValue.toString());
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final float GetParamFloatValue(String strParamName, float fDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamFloatValue(strParamName, fDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            return Float.parseFloat(objValue.toString());
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public final BigDecimal GetParamBigDecimalValue(String strParamName, BigDecimal fDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamBigDecimalValue(strParamName, fDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            return BigDecimal.valueOf(Double.parseDouble(objValue.toString()));
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public final double GetParamDoubleValue(String strParamName, double fDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamDoubleValue(strParamName, fDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            return Double.parseDouble(objValue.toString());
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public final long GetParamLongValue(String strParamName, long nDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamLongValue(strParamName, nDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return (Long)objValue;
            }
            if (objValue instanceof Double) {
                return ((Double)objValue).longValue();
            }
            if (objValue instanceof BigDecimal) {
                return ((BigDecimal)objValue).longValue();
            }
            return Long.parseLong(objValue.toString());
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public final boolean GetParamBoolValue(String strParamName, boolean bDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamBoolValue(strParamName, bDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        try {
            return Boolean.parseBoolean(objValue.toString());
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public final String getParamStringValue(String strParamName, String strDefault) {
        return this.GetParamStringValue(strParamName, strDefault);
    }

    @Deprecated
    public final String GetParamStringValue(String strParamName, String strDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamStringValue(strParamName, strDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            if (objValue instanceof String) {
                return (String)objValue;
            }
            return objValue.toString();
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public final String GetParamClobValue(String strParamName, String strDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamClobValue(strParamName, strDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            if (objValue instanceof Clob) {
                boolean bFirst = true;
                Clob clob = (Clob)objValue;
                BufferedReader br = new BufferedReader(clob.getCharacterStream());
                String s = br.readLine();
                StringBuffer sb = new StringBuffer();
                while (s != null) {
                    if (bFirst) {
                        bFirst = false;
                    } else {
                        sb.append("\r\n");
                    }
                    sb.append(s);
                    s = br.readLine();
                }
                return sb.toString();
            }
            return objValue.toString();
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public final Date GetParamDateValue(String strParamName, Date dtDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamDateValue(strParamName, dtDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return dtDefault;
        }
        try {
            if (objValue instanceof Date) {
                return (Date)objValue;
            }
            if (objValue instanceof Timestamp) {
                Timestamp ti = (Timestamp)objValue;
                return new Date(ti.getTime());
            }
            if (objValue instanceof java.util.Date) {
                java.util.Date ti = (java.util.Date)objValue;
                return new Date(ti.getTime());
            }
            return null;
        }
        catch (Exception ex) {
            return dtDefault;
        }
    }

    public final Timestamp GetParamTimestampValue(String strParamName, Timestamp dtDefault) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamTimestampValue(strParamName, dtDefault);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return dtDefault;
        }
        try {
            if (objValue instanceof Timestamp) {
                Timestamp ti = (Timestamp)objValue;
                return ti;
            }
            if (objValue instanceof Date) {
                Date date = (Date)objValue;
                return new Timestamp(date.getTime());
            }
            if (objValue instanceof java.util.Date) {
                java.util.Date date = (java.util.Date)objValue;
                return new Timestamp(date.getTime());
            }
            return null;
        }
        catch (Exception ex) {
            return dtDefault;
        }
    }

    public final BaseDataEntities GetParamDataEntitiesValue(String strParamName) {
        if (this.proxyDataEntity != null) {
            return this.proxyDataEntity.GetParamDataEntitiesValue(strParamName);
        }
        Object objValue = this.GetParamValue(strParamName);
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof BaseDataEntities) {
            return (BaseDataEntities)objValue;
        }
        return null;
    }

    public final void FillJSONObject(JSONObject objJSON) {
        this.FillJSONObject(objJSON, true);
    }

    public final void FillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.FillJSONObject(objJSON, bIncludeEmpty);
        } else {
            this.OnFillJSONObject(objJSON, bIncludeEmpty);
        }
    }

    protected void OnFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) {
        if (this.paramList != null) {
            BaseDataEntity.FillJSONObject(this.paramList, false, objJSON, bIncludeEmpty);
        }
        if (this.nullParamList != null && bIncludeEmpty) {
            BaseDataEntity.FillJSONObject(this.nullParamList, true, objJSON, bIncludeEmpty);
        }
    }

    private static void FillJSONObject(Hashtable paramList, boolean bEmptyParamList, JSONObject objJSON, boolean bIncludeEmpty) {
        if (paramList != null) {
            Enumeration keys = paramList.keys();
            while (keys.hasMoreElements()) {
                Object objKey = keys.nextElement();
                if (bEmptyParamList) {
                    try {
                        objJSON.put(objKey.toString().toLowerCase(), (Object)new JSONObject(true));
                    }
                    catch (Exception ex) {
                        StringHelper.Format((String)"Object[%1$s][%2$s] to JSON Error\uff01", objKey, (Object)"NULL");
                    }
                    continue;
                }
                Object objValue = paramList.get(objKey);
                if (objKey == null || objValue == null) continue;
                try {
                    JSONObject dt;
                    if (objValue instanceof BaseDataEntities) {
                        objJSON.put(objKey.toString().toLowerCase(), (Object)((BaseDataEntities)objValue).ToJSONArray(bIncludeEmpty));
                        continue;
                    }
                    if (objValue instanceof java.util.Date) {
                        dt = new JSONObject();
                        dt.put("time", ((java.util.Date)objValue).getTime());
                        objJSON.put(objKey.toString().toLowerCase(), (Object)dt);
                        continue;
                    }
                    if (objValue instanceof Date) {
                        dt = new JSONObject();
                        dt.put("time", ((Date)objValue).getTime());
                        objJSON.put(objKey.toString().toLowerCase(), (Object)dt);
                        continue;
                    }
                    if (objValue instanceof Timestamp) {
                        dt = new JSONObject();
                        dt.put("time", ((Timestamp)objValue).getTime());
                        objJSON.put(objKey.toString().toLowerCase(), (Object)dt);
                        continue;
                    }
                    objJSON.put(objKey.toString().toLowerCase(), objValue);
                }
                catch (Exception ex) {
                    StringHelper.Format((String)"Object[%1$s][%2$s] to JSON Error\uff01", objKey, objValue);
                    objJSON.put(objKey.toString().toLowerCase(), (Object)objValue.toString());
                }
            }
        }
    }

    public final String ToJSONString() {
        return BaseDataEntity.ToJSONString(this, false);
    }

    public static String ToJSONString(BaseDataEntity dataEntity, boolean bIncludeEmpty) {
        JSONObject jsonObj = new JSONObject();
        dataEntity.FillJSONObject(jsonObj, bIncludeEmpty);
        return jsonObj.toString();
    }

    public static JSONObject ToJSONObject(BaseDataEntity dataEntity, boolean bIncludeEmpty) {
        JSONObject jsonObj = new JSONObject();
        dataEntity.FillJSONObject(jsonObj, bIncludeEmpty);
        return jsonObj;
    }

    public final void ToXML(SRFExWebContext webContext, XmlWriter writer, String strTagName, DataEntityConfig dataEntityConfig) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.ToXML(webContext, writer, strTagName, dataEntityConfig);
        } else {
            try {
                writer.writeEntity(strTagName);
                for (Object objParam : dataEntityConfig.getList()) {
                    DataEntityItemConfig param = (DataEntityItemConfig)((Object)objParam);
                    String strValue = param.GetFormItemValue(webContext, this);
                    if (StringHelper.Length((String)strValue) <= 0) continue;
                    writer.writeAttribute(param.getName(), strValue);
                }
                this.ChildToXML(webContext, writer);
                writer.endEntity();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void ChildToXML(SRFExWebContext webContext, XmlWriter writer) {
    }

    public final void CopyTo(BaseDataEntity dataEntity, boolean bReset) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.CopyTo(dataEntity, bReset);
        } else {
            if (bReset) {
                dataEntity.Reset();
            }
            if (this.paramList != null) {
                BaseDataEntity.CopyTo(this.paramList, false, dataEntity);
            }
            if (this.nullParamList != null) {
                BaseDataEntity.CopyTo(this.nullParamList, true, dataEntity);
            }
        }
    }

    private static void CopyTo(Hashtable paramList, boolean bEmptyParamList, BaseDataEntity dataEntity) {
        Enumeration keys = paramList.keys();
        while (keys.hasMoreElements()) {
            Object objKey = keys.nextElement();
            if (bEmptyParamList) {
                dataEntity.SetParamValue((String)objKey, null);
                continue;
            }
            Object objValue = paramList.get(objKey);
            if (objValue instanceof BaseDataEntities) {
                dataEntity.SetParamValue((String)objKey, ((BaseDataEntities)objValue).clone());
                continue;
            }
            dataEntity.SetParamValue((String)objKey, objValue);
        }
    }

    public final void CopyTo(BaseDataEntity dataEntity, String strParamNames, boolean bReset) {
        if (this.proxyDataEntity != null) {
            this.proxyDataEntity.CopyTo(dataEntity, strParamNames, bReset);
        } else {
            if (bReset) {
                dataEntity.Reset();
            }
            strParamNames = strParamNames.replace(';', '|');
            strParamNames = strParamNames.replace(',', '|');
            String[] strParamName = strParamNames.split("[|]");
            int nCount = strParamName.length;
            int i = 0;
            while (i < nCount) {
                if (this.ContainesParam(strParamName[i])) {
                    dataEntity.SetParamValue(strParamName[i], this.GetParamValue(strParamName[i]));
                }
                ++i;
            }
        }
    }

    public static final String ToString(BaseDataEntity dataEntity, boolean bIncludeEmpty) {
        ByteArrayOutputStream byteOutputStream = null;
        ObjectOutputStream objOutput = null;
        try {
            Object objValue;
            Object objName;
            byteOutputStream = new ByteArrayOutputStream();
            objOutput = new ObjectOutputStream(byteOutputStream);
            Integer nCount = 0;
            Enumeration enumeration = dataEntity.getTotalParamList().keys();
            while (enumeration.hasMoreElements()) {
                try {
                    objName = enumeration.nextElement();
                    objValue = dataEntity.GetParamValue(objName.toString());
                    if (objValue == null && !bIncludeEmpty) continue;
                    nCount = nCount + 1;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
            objOutput.writeObject(nCount);
            enumeration = dataEntity.getTotalParamList().keys();
            while (enumeration.hasMoreElements()) {
                try {
                    objName = enumeration.nextElement();
                    objValue = dataEntity.GetParamValue(objName.toString());
                    if (objValue == null) {
                        if (!bIncludeEmpty) continue;
                        objOutput.writeObject(objName);
                        objOutput.writeObject(objValue);
                        continue;
                    }
                    objOutput.writeObject(objName);
                    objOutput.writeObject(objValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
            objOutput.flush();
            objOutput.close();
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        if (byteOutputStream != null) {
            String strOutput = Base64.encodeBytes((byte[])byteOutputStream.toByteArray(), (int)2);
            return strOutput;
        }
        return "";
    }

    public static final String ToString(BaseDataEntity dataEntity) {
        return BaseDataEntity.ToString(dataEntity, false);
    }

    public static final BaseDataEntity FromString(BaseDataEntity dataEntity, String strString) {
        Object objCount;
        ObjectInputStream objInput;
        block8: {
            if (StringHelper.StringLength((String)strString) == 0) {
                return dataEntity;
            }
            if (dataEntity == null) {
                dataEntity = new BaseDataEntity();
            }
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode((String)strString));
            objInput = new ObjectInputStream(inputStream);
            objCount = objInput.readObject();
            if (objCount != null) break block8;
            return null;
        }
        try {
            Integer nCount = (Integer)objCount;
            while (nCount > 0) {
                try {
                    nCount = nCount - 1;
                    Object objKey = objInput.readObject();
                    Object objValue = objInput.readObject();
                    dataEntity.setParamValue(objKey.toString(), objValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    break;
                }
            }
            objInput.close();
            return dataEntity;
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static final BaseDataEntity FromString(String strString) {
        return BaseDataEntity.FromString(null, strString);
    }

    public static final Map ToMap(String strString) {
        Object objCount;
        ObjectInputStream objInput;
        TreeMap<Object, Object> map;
        block7: {
            if (StringHelper.StringLength((String)strString) == 0) {
                return null;
            }
            map = new TreeMap<Object, Object>();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode((String)strString));
            objInput = new ObjectInputStream(inputStream);
            objCount = objInput.readObject();
            if (objCount != null) break block7;
            return null;
        }
        try {
            Integer nCount = (Integer)objCount;
            while (nCount > 0) {
                try {
                    nCount = nCount - 1;
                    Object objKey = objInput.readObject();
                    Object objValue = objInput.readObject();
                    map.put(objKey, objValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    break;
                }
            }
            objInput.close();
            return map;
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            return null;
        }
    }

    public static final String CalcDigest(BaseDataEntity dataEntity, String strFields) {
        if (StringHelper.IsNullOrEmpty((String)strFields) || dataEntity == null) {
            return "";
        }
        String[] fields = StringHelper.SplitEx((String)strFields);
        String strData = "";
        int i = 0;
        while (i < fields.length) {
            if (i != 0) {
                strData = String.valueOf(strData) + "|";
            }
            strData = String.valueOf(strData) + dataEntity.GetParamStringValue(fields[i], "");
            ++i;
        }
        return Helper.GenMD5((String)strData);
    }

    @Deprecated
    public static final boolean Compare(BaseDataEntity arg1, BaseDataEntity arg2, HashMap<String, Integer> ignoreMap) {
        return BaseDataEntity.compare(arg1, arg2, ignoreMap);
    }

    public static final boolean compare(BaseDataEntity arg1, BaseDataEntity arg2, HashMap<String, Integer> ignoreMap) {
        Hashtable paramList = arg1.getTotalParamList();
        Hashtable paramList2 = arg2.getTotalParamList();
        for (Object objKey : paramList.keySet()) {
            Object objValue2 = paramList2.remove(objKey);
            if (ignoreMap.containsKey(objKey)) continue;
            if (objValue2 == null) {
                return false;
            }
            Object objValue1 = paramList.get(objKey);
            try {
                if (objValue1.equals(objValue2) || StringHelper.Compare((String)objValue1.toString(), (String)objValue2.toString(), (boolean)false) == 0) continue;
                return false;
            }
            catch (Exception ex) {
                return false;
            }
        }
        for (Object objKey : paramList2.keySet()) {
            if (ignoreMap.containsKey(objKey)) continue;
            return false;
        }
        return true;
    }
}

