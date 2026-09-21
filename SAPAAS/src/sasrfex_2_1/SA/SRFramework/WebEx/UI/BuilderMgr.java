/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.UI.BuilderConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class BuilderMgr
extends ConfigMgr {
    private static final Log log = LogFactory.getLog(BuilderMgr.class);
    private final byte[] key;

    public BuilderMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BuilderConfig Get(String strThemeId) {
        String strBuilderConfigPath;
        block12: {
            strBuilderConfigPath = this.GetConfigFilePath("themeex" + this.strFolderSeperator + this.GetRealPath(strThemeId) + ".xml");
            File file = new File(strBuilderConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strBuilderConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strBuilderConfigPath))) {
                        return (BuilderConfig)((Object)this.fileList.get(strBuilderConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(BuilderMgr.getContent((String)strBuilderConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strBuilderConfigPath);
                    }
                    Document doc = parser.getDocument();
                    BuilderConfig builderConfig = new BuilderConfig();
                    if (!builderConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strBuilderConfigPath, builderConfig);
                        this.modifydateList.put(strBuilderConfigPath, nLastModify);
                    }
                    return builderConfig;
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage(), (Throwable)ex);
                    return new BuilderConfig();
                }
            }
        }
        log.error((Object)StringHelper.Format((String)"\u6784\u5efa\u5668\u914d\u7f6e\u6587\u4ef6[%1$s]\u65e0\u6548\uff0c\u4f7f\u7528\u7a7a\u767d\u914d\u7f6e", (Object)strBuilderConfigPath));
        return new BuilderConfig();
    }
}

