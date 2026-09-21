/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONNull
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.data;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.ibizsys.paas.data.DataObjectList;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.IDataColumn;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DataObject
implements IDataObject {
    private static final Log log = LogFactory.getLog(DataObject.class);
    public static final Object EMPTY = new Object();
    private HashMap<String, Object> paramMap = null;
    private Object objParamMapLock = new Object();
    private IDataObject proxyDataObject = null;

    @Override
    public void proxy(IDataObject proxyDataObject) {
        this.proxyDataObject = proxyDataObject;
        this.onProxy(proxyDataObject);
    }

    protected void onProxy(IDataObject proxyDataObject) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void reset() {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.reset();
        } else {
            Object object = this.objParamMapLock;
            synchronized (object) {
                if (this.paramMap != null) {
                    this.paramMap.clear();
                    this.paramMap = null;
                }
            }
            this.onReset();
        }
    }

    protected void onReset() {
    }

    public static IDataObject fromJSONString(String strJSONString) throws Exception {
        JSONObject jsonObject = JSONObjectHelper.fromString(strJSONString);
        return DataObject.fromJSONObject(jsonObject);
    }

    public static IDataObject fromJSONObject(JSONObject jsonObject) throws Exception {
        return DataObject.fromJSONObject(null, jsonObject);
    }

    public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject) throws Exception {
        return DataObject.fromJSONObject(baseDataEntity, jsonObject, false);
    }

    public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject, boolean bIgnoreException) throws Exception {
        return DataObject.fromJSONObject(baseDataEntity, jsonObject, bIgnoreException, false);
    }

    public static IDataObject fromJSONObject(IDataObject baseDataEntity, JSONObject jsonObject, boolean bIgnoreException, boolean bIgnoreArray) throws Exception {
        if (baseDataEntity == null) {
            baseDataEntity = new DataObject();
        }
        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            Object objKey = it.next();
            Object objValue = jsonObject.get(objKey.toString());
            try {
                if (objValue instanceof JSONNull) {
                    baseDataEntity.set(objKey.toString(), null);
                    continue;
                }
                if (objValue instanceof JSONArray) {
                    if (bIgnoreArray) {
                        baseDataEntity.set(objKey.toString(), objValue.toString());
                        continue;
                    }
                    baseDataEntity.set(objKey.toString(), DataObjectList.fromJSONArray((JSONArray)objValue));
                    continue;
                }
                if (objValue instanceof JSONObject) {
                    JSONObject jo = (JSONObject)objValue;
                    if (jo.has("time") || jo.has("timestr")) {
                        long lTime = 0L;
                        lTime = jo.has("timestr") ? Long.parseLong(jo.getString("timestr")) : jo.getLong("time");
                        Timestamp date = new Timestamp(lTime);
                        baseDataEntity.set(objKey.toString(), date);
                        continue;
                    }
                    baseDataEntity.set(objKey.toString(), jo.toString());
                    continue;
                }
                baseDataEntity.set(objKey.toString(), objValue);
            }
            catch (Exception ex) {
                if (bIgnoreException) continue;
                throw ex;
            }
        }
        return baseDataEntity;
    }

    public static IDataObject fromXmlNode(IDataObject baseDataEntity, XmlNode xmlNode) throws Exception {
        if (baseDataEntity == null) {
            baseDataEntity = new DataObject();
        }
        Iterator<String> keys = xmlNode.getAttributes();
        while (keys.hasNext()) {
            String strKey = keys.next();
            String strValue = xmlNode.getAttribute(strKey, null);
            baseDataEntity.set(strKey, strValue);
        }
        return baseDataEntity;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.proxyDataObject != null) {
            return this.proxyDataObject.contains(strParamName);
        }
        if (strParamName == null) {
            return false;
        }
        strParamName = strParamName.toUpperCase();
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                return this.paramMap.containsKey(strParamName);
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.proxyDataObject != null) {
            return this.proxyDataObject.isNull(strParamName);
        }
        strParamName = strParamName.toUpperCase();
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                // MONITOREXIT @DISABLED, blocks:[0, 1, 3] lbl8 : MonitorExitStatement: MONITOREXIT : var2_2
                Object objValue = this.paramMap.get(strParamName);
                return objValue == null || objValue == EMPTY;
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.proxyDataObject != null) {
            return this.proxyDataObject.remove(strParamName);
        }
        if (StringHelper.length(strParamName) == 0) {
            return false;
        }
        strParamName = strParamName.toUpperCase();
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                return this.paramMap.remove(strParamName) != null;
            }
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if (this.proxyDataObject != null) {
            return this.proxyDataObject.get(strParamName);
        }
        String strParamName2 = strParamName.toUpperCase();
        Object object = this.objParamMapLock;
        synchronized (object) {
            Object objValue;
            block7: {
                block6: {
                    if (this.paramMap != null) break block6;
                    return null;
                }
                objValue = this.paramMap.get(strParamName2);
                if (objValue != EMPTY) break block7;
                return null;
            }
            return objValue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void set(String strParamName, Object objParamValue) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.set(strParamName, objParamValue);
        } else {
            if (StringHelper.isNullOrEmpty(strParamName)) {
                return;
            }
            strParamName = strParamName.toUpperCase();
            Object object = this.objParamMapLock;
            synchronized (object) {
                if (this.paramMap == null) {
                    this.paramMap = new HashMap();
                }
                if (objParamValue == null) {
                    this.paramMap.put(strParamName, EMPTY);
                } else {
                    this.paramMap.put(strParamName, objParamValue);
                }
            }
        }
    }

    public static final int getIntegerValue(IDataObject iDataObject, String strParamName, int nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        if (objValue instanceof Integer) {
            return (Integer)objValue;
        }
        if (objValue instanceof Double) {
            return ((Double)objValue).intValue();
        }
        if (objValue instanceof BigDecimal) {
            return ((BigDecimal)objValue).intValue();
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return nDefault;
        }
        strValue = strValue.replace(",", "");
        return Integer.parseInt(strValue);
    }

    public static final Object getObjectValue(Object objValue) throws Exception {
        return objValue;
    }

    public static final Integer getIntegerValue(Object objValue) throws Exception {
        return DataObject.getIntegerValue(objValue, null);
    }

    public static final Integer getIntegerValue(Object objValue, Integer def) throws Exception {
        if (objValue == null) {
            return def;
        }
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
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return def;
        }
        strValue = strValue.replace(",", "");
        return Integer.parseInt(strValue);
    }

    public static final Float getFloatValue(IDataObject iDataObject, String strParamName, float fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return Float.valueOf(fDefault);
        }
        try {
            if (objValue instanceof Float) {
                return (Float)objValue;
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return Float.valueOf(fDefault);
            }
            strValue = strValue.replace(",", "");
            return Float.valueOf(Float.parseFloat(strValue));
        }
        catch (Exception ex) {
            return Float.valueOf(fDefault);
        }
    }

    public static final Float getFloatValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof Float) {
            return (Float)objValue;
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        strValue = strValue.replace(",", "");
        return Float.valueOf(Float.parseFloat(strValue));
    }

    public static final BigDecimal getBigDecimalValue(IDataObject iDataObject, String strParamName, BigDecimal fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            if (objValue instanceof Double) {
                return BigDecimal.valueOf((Double)objValue);
            }
            if (objValue instanceof Long) {
                return BigDecimal.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return fDefault;
            }
            strValue = strValue.replace(",", "");
            return BigDecimal.valueOf(Double.parseDouble(strValue));
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public static final BigDecimal getBigDecimalValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof BigDecimal) {
            return (BigDecimal)objValue;
        }
        if (objValue instanceof Double) {
            return BigDecimal.valueOf((Double)objValue);
        }
        if (objValue instanceof Long) {
            return BigDecimal.valueOf((Long)objValue);
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        strValue = strValue.replace(",", "");
        return BigDecimal.valueOf(Double.parseDouble(strValue));
    }

    public static final BigInteger getBigIntegerValue(IDataObject iDataObject, String strParamName, BigInteger nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return BigInteger.valueOf((Long)objValue);
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return nDefault;
            }
            strValue = strValue.replace(",", "");
            return BigInteger.valueOf(Long.parseLong(strValue));
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public static final BigInteger getBigIntegerValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof BigInteger) {
            return (BigInteger)objValue;
        }
        if (objValue instanceof Long) {
            return BigInteger.valueOf((Long)objValue);
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        strValue = strValue.replace(",", "");
        return BigInteger.valueOf(Long.parseLong(strValue));
    }

    public static final double getDoubleValue(IDataObject iDataObject, String strParamName, double fDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return fDefault;
        }
        try {
            if (objValue instanceof Double) {
                return (Double)objValue;
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return fDefault;
            }
            strValue = strValue.replace(",", "");
            return Double.parseDouble(strValue);
        }
        catch (Exception ex) {
            return fDefault;
        }
    }

    public static final Double getDoubleValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof Double) {
            return (Double)objValue;
        }
        String strValue = objValue.toString();
        if (StringHelper.isNullOrEmpty(strValue)) {
            return null;
        }
        strValue = strValue.replace(",", "");
        return Double.parseDouble(strValue);
    }

    public static final long getLongValue(IDataObject iDataObject, String strParamName, long nDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return (Long)objValue;
            }
            if (objValue instanceof Integer) {
                return ((Integer)objValue).longValue();
            }
            if (objValue instanceof Double) {
                return ((Double)objValue).longValue();
            }
            if (objValue instanceof BigDecimal) {
                return ((BigDecimal)objValue).longValue();
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return nDefault;
            }
            strValue = strValue.replace(",", "");
            return Long.parseLong(objValue.toString());
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public static final Long getLongValue(Object objValue, Long nDefault) throws Exception {
        if (objValue == null) {
            return nDefault;
        }
        try {
            if (objValue instanceof Long) {
                return (Long)objValue;
            }
            if (objValue instanceof Integer) {
                return ((Integer)objValue).longValue();
            }
            if (objValue instanceof Double) {
                return ((Double)objValue).longValue();
            }
            if (objValue instanceof BigDecimal) {
                return ((BigDecimal)objValue).longValue();
            }
            String strValue = objValue.toString();
            if (StringHelper.isNullOrEmpty(strValue)) {
                return nDefault;
            }
            strValue = strValue.replace(",", "");
            return Long.parseLong(objValue.toString());
        }
        catch (Exception ex) {
            return nDefault;
        }
    }

    public static final String getStringValue(IDataObject iDataObject, String strParamName, String strDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return strDefault;
        }
        try {
            return DataObject.getStringValue(objValue);
        }
        catch (Exception ex) {
            return strDefault;
        }
    }

    public static final String getStringValue(Object objValue) throws Exception {
        return DataObject.getStringValue(objValue, null);
    }

    public static final String getStringValue(Object objValue, String strDefault) throws Exception {
        if (objValue == null) {
            return strDefault;
        }
        if (objValue instanceof String) {
            return (String)objValue;
        }
        return objValue.toString();
    }

    public static final byte[] getBinaryValue(Object objValue) throws Exception {
        return DataObject.getBinaryValue(objValue, null);
    }

    public static final byte[] getBinaryValue(Object objValue, byte[] def) throws Exception {
        if (objValue == null) {
            return def;
        }
        if (objValue instanceof byte[]) {
            return (byte[])objValue;
        }
        if (objValue instanceof String) {
            return Base64Helper.decode((String)objValue);
        }
        return def;
    }

    public static final String getClobValue(IDataObject iDataObject, String strParamName, String strDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
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

    public static final Timestamp getTimestampValue(IDataObject iDataObject, String strParamName, Timestamp dtDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return dtDefault;
        }
        try {
            return DataObject.getTimestampValue(objValue);
        }
        catch (Exception ex) {
            return dtDefault;
        }
    }

    public static final Timestamp getTimestampValue(Object objValue) throws Exception {
        if (objValue == null) {
            return null;
        }
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
        if (objValue instanceof String) {
            String strValue = (String)objValue;
            if (StringHelper.isNullOrEmpty(strValue = strValue.trim())) {
                return null;
            }
            java.util.Date date = DateHelper.parse((String)objValue);
            return new Timestamp(date.getTime());
        }
        if (objValue instanceof Long) {
            Long lValue = (Long)objValue;
            return new Timestamp(lValue);
        }
        if (objValue instanceof Integer) {
            int lValue = (Integer)objValue;
            return new Timestamp(lValue);
        }
        throw new Exception(StringHelper.format("\u65e0\u6cd5\u8f6c\u6362\u65f6\u95f4[%1$s]", objValue));
    }

    public static final DataObjectList getDataObjectsValue(IDataObject iDataObject, String strParamName) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return null;
        }
        if (objValue instanceof DataObjectList) {
            return (DataObjectList)objValue;
        }
        return null;
    }

    @Override
    public final void copyTo(IDataObject dataEntity, String strParamNames, boolean bReset) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.copyTo(dataEntity, strParamNames, bReset);
        } else {
            if (bReset) {
                dataEntity.reset();
            }
            strParamNames = strParamNames.replace(';', '|');
            strParamNames = strParamNames.replace(',', '|');
            String[] strParamName = strParamNames.split("[|]");
            int nCount = strParamName.length;
            int i = 0;
            while (i < nCount) {
                if (this.contains(strParamName[i])) {
                    dataEntity.set(strParamName[i], this.get(strParamName[i]));
                }
                ++i;
            }
        }
    }

    @Override
    public void copyTo(IDataObject dataEntity, boolean bReset) throws Exception {
        this.copyTo(dataEntity, bReset, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void copyTo(IDataObject dataEntity, boolean bReset, boolean bIncludeEmpty) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.copyTo(dataEntity, bReset, bIncludeEmpty);
        } else {
            if (bReset) {
                dataEntity.reset();
            }
            Object object = this.objParamMapLock;
            synchronized (object) {
                if (this.paramMap != null) {
                    for (Map.Entry<String, Object> entry : this.paramMap.entrySet()) {
                        Object objValue = entry.getValue();
                        if (objValue == EMPTY) {
                            objValue = null;
                        }
                        if (!bIncludeEmpty && objValue == null) continue;
                        dataEntity.set(entry.getKey(), objValue);
                    }
                }
            }
        }
    }

    public static void fromDataRow(IDataObject iDataObject, IDataRow dr, boolean bReset) throws Exception {
        IDataTable dataTable;
        if (bReset) {
            iDataObject.reset();
        }
        if ((dataTable = dr.getDataTable()) != null) {
            int nColumnCount = dataTable.getColumnCount();
            int i = 0;
            while (i < nColumnCount) {
                IDataColumn dataColumn = dataTable.getDataColumn(i);
                if (dr.isDBNull(i)) {
                    iDataObject.set(dataColumn.getName(), null);
                } else {
                    iDataObject.set(dataColumn.getName(), dr.get(i));
                }
                ++i;
            }
        } else if (dr instanceof IDataObject) {
            IDataObject srcDataObject = (IDataObject)((Object)dr);
            srcDataObject.copyTo(iDataObject, true);
        } else {
            throw new Exception("\u65e0\u6548\u7684\u884c\u6570\u636e\u5bf9\u8c61");
        }
    }

    public static void fromDataRow(IDataObject iDataObject, IDataRow dr) throws Exception {
        DataObject.fromDataRow(iDataObject, dr, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fillMap(HashMap<String, Object> params) {
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                params.putAll(this.paramMap);
            }
        }
    }

    public static JSONObject toJSONObject(IDataObject iDataObject, boolean bIncludeEmpty) throws Exception {
        JSONObject jsonObj = new JSONObject();
        iDataObject.fillJSONObject(jsonObj, bIncludeEmpty);
        return jsonObj;
    }

    public static JSONObject toJSONObject(IDataObject iDataObject, boolean bDirtyOnly, boolean bIncludeEmpty) throws Exception {
        JSONObject jsonObj = new JSONObject();
        iDataObject.fillJSONObject(jsonObj, bDirtyOnly, bIncludeEmpty);
        return jsonObj;
    }

    public static JSONObject toJSONObject(IDataObject iDataObject, boolean bIncludeEmpty, JSONObject jsonObj) throws Exception {
        if (jsonObj == null) {
            jsonObj = new JSONObject();
        }
        iDataObject.fillJSONObject(jsonObj, bIncludeEmpty);
        return jsonObj;
    }

    public static JSONObject toJSONObject(IDataObject iDataObject, boolean bDirtyOnly, boolean bIncludeEmpty, JSONObject jsonObj) throws Exception {
        if (jsonObj == null) {
            jsonObj = new JSONObject();
        }
        iDataObject.fillJSONObject(jsonObj, bDirtyOnly, bIncludeEmpty);
        return jsonObj;
    }

    public static JSONObject convertJSONValueTimeFmt(JSONObject jsonObject, String strTimeFormat) throws Exception {
        JSONObject newJsonObject = new JSONObject();
        Iterator it = jsonObject.keys();
        while (it.hasNext()) {
            Object objKey = it.next();
            Object objValue = jsonObject.get(objKey.toString());
            if (objValue instanceof JSONObject) {
                JSONObject jo = (JSONObject)objValue;
                if (jo.has("time")) {
                    long lTime = jo.getLong("time");
                    Timestamp date = new Timestamp(lTime);
                    newJsonObject.put(objKey.toString(), (Object)StringHelper.format(strTimeFormat, date));
                    continue;
                }
                newJsonObject.put(objKey.toString(), (Object)jo);
                continue;
            }
            newJsonObject.put(objKey.toString(), objValue);
        }
        return newJsonObject;
    }

    @Override
    public void fillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.fillJSONObject(objJSON, bIncludeEmpty);
        } else {
            this.onFillJSONObject(objJSON, bIncludeEmpty);
        }
    }

    @Override
    public void fillJSONObject(JSONObject objJSON, boolean bDirtyOnly, boolean bIncludeEmpty) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.fillJSONObject(objJSON, bDirtyOnly, bIncludeEmpty);
        } else {
            this.onFillJSONObject(objJSON, bDirtyOnly, bIncludeEmpty);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                DataObject.fillJSONObject(this.paramMap, objJSON, bIncludeEmpty);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onFillJSONObject(JSONObject objJSON, boolean bDirtyOnly, boolean bIncludeEmpty) throws Exception {
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                DataObject.fillJSONObject(this.paramMap, objJSON, bIncludeEmpty);
            }
        }
    }

    private static void fillJSONObject(HashMap<String, Object> paramMap, JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        if (paramMap != null) {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                Object objValue = entry.getValue();
                String objKey = entry.getKey();
                if (objKey == null || objValue == null) continue;
                if (objValue == EMPTY) {
                    objValue = null;
                    if (!bIncludeEmpty) continue;
                }
                try {
                    if (objValue instanceof DataObjectList) {
                        objJSON.put(objKey.toString().toLowerCase(), (Object)((DataObjectList)objValue).toJSONArray(bIncludeEmpty));
                        continue;
                    }
                    objJSON.put(objKey.toString().toLowerCase(), DataObject.getJSONValue(objValue));
                }
                catch (Exception ex) {
                    StringHelper.format("Object[%1$s][%2$s] to JSON Error\uff01", objKey, objValue);
                    objJSON.put(objKey.toString().toLowerCase(), (Object)objValue.toString());
                }
            }
        }
    }

    protected static Object getJSONValue(Object objValue) throws Exception {
        return DataObject.getJSONValue(objValue, false);
    }

    protected static Object getJSONValue(Object objValue, boolean bStripQuotes) throws Exception {
        if (objValue == null) {
            return JSONNull.getInstance();
        }
        Long nValue = null;
        if (objValue instanceof Timestamp) {
            nValue = ((Timestamp)objValue).getTime();
        } else if (objValue instanceof Date) {
            nValue = ((Date)objValue).getTime();
        } else if (objValue instanceof java.util.Date) {
            nValue = ((java.util.Date)objValue).getTime();
        } else {
            if (objValue instanceof byte[]) {
                return Base64Helper.encodeBytes((byte[])objValue);
            }
            if (bStripQuotes) {
                return JSONObjectHelper.stripQuotes(objValue, true);
            }
            return objValue;
        }
        JSONObject dt = new JSONObject();
        if (nValue < 0L) {
            dt.put("timestr", (Object)Long.toString(nValue));
        } else {
            dt.put("time", (Object)nValue);
        }
        return dt;
    }

    public String toJSONString() throws Exception {
        return DataObject.toJSONString(this, false);
    }

    public static String toJSONString(IDataObject dataEntity, boolean bIncludeEmpty) throws Exception {
        JSONObject jsonObj = new JSONObject();
        dataEntity.fillJSONObject(jsonObj, bIncludeEmpty);
        return jsonObj.toString();
    }

    @Override
    public void fillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        if (this.proxyDataObject != null) {
            this.proxyDataObject.fillXmlNode(xmlNode, bIncludeEmpty);
        } else {
            this.onFillXmlNode(xmlNode, bIncludeEmpty);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        Object object = this.objParamMapLock;
        synchronized (object) {
            if (this.paramMap != null) {
                DataObject.fillXmlNode(this.paramMap, xmlNode, bIncludeEmpty);
            }
        }
    }

    private static void fillXmlNode(HashMap<String, Object> paramMap, XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        if (paramMap != null) {
            for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
                Object objValue = entry.getValue();
                String objKey = entry.getKey();
                if (objKey == null || objValue == null) continue;
                if (objValue == EMPTY) {
                    objValue = null;
                    if (!bIncludeEmpty) continue;
                }
                if (objValue == null) {
                    xmlNode.setAttribute(objKey, "");
                    continue;
                }
                xmlNode.setAttribute(objKey, objValue.toString());
            }
        }
    }

    public static final Boolean getBoolValue(IDataObject iDataObject, String strParamName, Boolean bDefault) throws Exception {
        Object objValue = iDataObject.get(strParamName);
        if (objValue == null) {
            return bDefault;
        }
        try {
            String strValueString = objValue.toString();
            if (StringHelper.compare(strValueString, "TRUE", true) == 0) {
                return true;
            }
            if (StringHelper.compare(strValueString, "1", true) == 0) {
                return true;
            }
            return Boolean.parseBoolean(strValueString);
        }
        catch (Exception ex) {
            return bDefault;
        }
    }

    public static boolean getBoolValue(Integer nValue, boolean bDefault) {
        if (nValue == null) {
            return bDefault;
        }
        return nValue == 1;
    }

    public static boolean getBoolValue(Object objValue, boolean bDefault) {
        String strValueString;
        block6: {
            block5: {
                if (objValue == null) {
                    return bDefault;
                }
                try {
                    strValueString = objValue.toString();
                    if (StringHelper.compare(strValueString, "TRUE", true) != 0) break block5;
                    return true;
                }
                catch (Exception ex) {
                    return bDefault;
                }
            }
            if (StringHelper.compare(strValueString, "1", true) != 0) break block6;
            return true;
        }
        return Boolean.parseBoolean(strValueString);
    }
}

