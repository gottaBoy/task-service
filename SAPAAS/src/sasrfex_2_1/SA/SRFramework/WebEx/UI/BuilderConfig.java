/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.commons.pool.BaseKeyedPoolableObjectFactory
 *  org.apache.commons.pool.KeyedPoolableObjectFactory
 *  org.apache.commons.pool.impl.GenericKeyedObjectPool
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.Builder.BaseBuilder;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.pool.BaseKeyedPoolableObjectFactory;
import org.apache.commons.pool.KeyedPoolableObjectFactory;
import org.apache.commons.pool.impl.GenericKeyedObjectPool;
import org.w3c.dom.Node;

public class BuilderConfig
extends XMLConfig {
    private static final Log log = LogFactory.getLog(BuilderConfig.class);
    public static final String TAG_BUILDER = "SRFEXBUILDER";
    public static final String TAG_NAME = "NAME";
    public static final String TAG_MODE = "MODE";
    public static final String TAG_TYPE = "TYPE";
    protected Hashtable<String, String> builderMap = new Hashtable();
    protected GenericKeyedObjectPool builderPool = new GenericKeyedObjectPool((KeyedPoolableObjectFactory)new BuilderKeyedPoolableObjectFactory());

    public BuilderConfig() {
        this.builderPool.setWhenExhaustedAction((byte)2);
    }

    public BaseBuilder GetBuilderFromPool(String strBuilderName, String strBuilderMode) {
        Object objBuilder;
        block3: {
            String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strBuilderName, (Object)strBuilderMode);
            strKey = strKey.toUpperCase();
            try {
                objBuilder = this.builderPool.borrowObject((Object)strKey);
                if (objBuilder != null) break block3;
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u754c\u9762\u6784\u5efa\u5668[%1$s]", (Object)strKey));
                return null;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                return null;
            }
        }
        return (BaseBuilder)objBuilder;
    }

    public void ReleaseBuilder(String strBuilderName, String strBuilderMode, BaseBuilder builder) {
        try {
            String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strBuilderName, (Object)strBuilderMode);
            strKey = strKey.toUpperCase();
            this.builderPool.returnObject((Object)strKey, (Object)builder);
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    public BaseBuilder GetBuilder(String strBuilderName, String strBuilderMode) {
        BaseBuilder builder;
        String strType;
        Object objBuilder;
        String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strBuilderName, (Object)strBuilderMode);
        if (this.builderMap.containsKey((strKey = strKey.toUpperCase()).toUpperCase()) && (objBuilder = ObjectHelper.Create(strType = this.builderMap.get(strKey))) instanceof BaseBuilder && StringHelper.Compare((String)strBuilderName, (String)(builder = (BaseBuilder)objBuilder).getBuilderName(), (boolean)true) == 0) {
            return builder;
        }
        log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6[%1$s]\u5bf9\u5e94\u7684\u914d\u7f6e\u5bf9\u8c61\uff0c\u5f53\u524d\u914d\u7f6e\u6570\u91cf\u4e3a[%2$s]", (Object)strKey, (Object)this.builderMap.size()));
        return null;
    }

    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare((String)strName, (String)TAG_BUILDER, (boolean)true) == 0) {
            XMLConfig xmlConfig = new XMLConfig();
            if (xmlConfig.LoadConfig(xmlNode)) {
                String strBuilderName = xmlConfig.GetExtValue(TAG_NAME, "");
                String strBuilderMode = xmlConfig.GetExtValue(TAG_MODE, "");
                String strType = xmlConfig.GetExtValue(TAG_TYPE, "");
                if (StringHelper.Length((String)strType) == 0) {
                    return;
                }
                String strKey = StringHelper.Format((String)"%1$s:%2$s", (Object)strBuilderName, (Object)strBuilderMode);
                this.builderMap.put(strKey.toUpperCase(), strType);
            }
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    private class BuilderKeyedPoolableObjectFactory
    extends BaseKeyedPoolableObjectFactory {
        private BuilderKeyedPoolableObjectFactory() {
        }

        public Object makeObject(Object arg0) throws Exception {
            String strType;
            Object objBuilder;
            String strKey = (String)arg0;
            if (BuilderConfig.this.builderMap.containsKey(strKey) && (objBuilder = ObjectHelper.Create(strType = BuilderConfig.this.builderMap.get(strKey))) instanceof BaseBuilder) {
                BaseBuilder builder = (BaseBuilder)objBuilder;
                return builder;
            }
            return null;
        }

        public void passivateObject(Object key, Object obj) throws Exception {
            if (obj != null) {
                ((BaseBuilder)obj).Reset();
            }
            super.passivateObject(key, obj);
        }
    }
}

