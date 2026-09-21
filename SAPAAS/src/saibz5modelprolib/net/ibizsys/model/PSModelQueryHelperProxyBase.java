/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONArray
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Vector;
import net.ibizsys.model.IPSModelQueryHelper;
import net.ibizsys.model.entity.BaseDataEntity;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSModelQueryHelperProxyBase {
    private static final Log log = LogFactory.getLog(PSModelQueryHelperProxyBase.class);

    protected abstract IPSModelQueryHelper getHelper();

    protected abstract String getCacheFolder();

    protected CallResult readCache(String strType, String strTag, BaseDataEntity entity) {
        String strCacheFile = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.json", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType, (Object)strTag);
        File file = new File(strCacheFile);
        if (!file.exists()) {
            return null;
        }
        try {
            CallResult callResult = new CallResult();
            String strJson = PSModelQueryHelperProxyBase.readFile(strCacheFile);
            if (StringHelper.isNullOrEmpty((String)strJson)) {
                callResult.setRetCode(3);
                return callResult;
            }
            JSONObject jObject = JSONObjectHelper.fromString((String)strJson);
            DataObject.fromJSONObject((IDataObject)entity, (JSONObject)jObject);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8bfb\u53d6Json\u7f13\u5b58[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strCacheFile, (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    protected String writeCache(String strType, String strTag, BaseDataEntity entity) {
        String strCacheFileFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType);
        File folder = new File(strCacheFileFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String strCacheFile = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.json", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType, (Object)strTag);
        try {
            String strJson = "";
            if (entity != null) {
                JSONObject jo = DataObject.toJSONObject((IDataObject)entity, (boolean)false);
                strJson = jo.toString();
            }
            PSModelQueryHelperProxyBase.write(strCacheFile, strJson);
            return strCacheFile;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5199\u5165Json\u7f13\u5b58[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strCacheFile, (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    protected CallResult readCache2(String strType, String strTag, Class cls, Vector list) {
        String strCacheFile = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.json", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType, (Object)strTag);
        File file = new File(strCacheFile);
        if (!file.exists()) {
            return null;
        }
        try {
            CallResult callResult = new CallResult();
            String strJson = PSModelQueryHelperProxyBase.readFile(strCacheFile);
            if (StringHelper.isNullOrEmpty((String)strJson)) {
                callResult.setRetCode(3);
                return callResult;
            }
            JSONArray ja = JSONArray.fromString((String)strJson);
            int i = 0;
            while (i < ja.length()) {
                JSONObject jo = ja.getJSONObject(i);
                BaseDataEntity baseDataEntity = (BaseDataEntity)((Object)cls.newInstance());
                DataObject.fromJSONObject((IDataObject)baseDataEntity, (JSONObject)jo);
                list.add(baseDataEntity);
                ++i;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8bfb\u53d6Json\u7f13\u5b58[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strCacheFile, (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    protected String writeCache2(String strType, String strTag, Vector list) {
        String strCacheFileFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType);
        File folder = new File(strCacheFileFolder);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String strCacheFile = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.json", (Object)this.getCacheFolder(), (Object)File.separator, (Object)strType, (Object)strTag);
        try {
            ArrayList<JSONObject> arr = new ArrayList<JSONObject>();
            for (Object obj : list) {
                arr.add(DataObject.toJSONObject((IDataObject)((BaseDataEntity)((Object)obj)), (boolean)false));
            }
            JSONArray ja = JSONArray.fromArray((Object[])arr.toArray());
            PSModelQueryHelperProxyBase.write(strCacheFile, ja.toString());
            return strCacheFile;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u5199\u5165Json\u7f13\u5b58[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strCacheFile, (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    protected static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        block15: {
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException iOException) {}
                    }
                    break block15;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        return sb.toString();
    }

    public static boolean write(String strFullPath, String strCode) throws Exception {
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
        return false;
    }
}

