/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.ConfigMgr
 *  org.apache.xerces.parsers.DOMParser
 */
package SA.SRFramework.WebEx.UI;

import SA.SRFramework.Base.ConfigMgr;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.WebEx.ISRFExFormItemValueTransform;
import SA.SRFramework.WebEx.UI.ValueTransformConfig;
import SA.SRFramework.WebEx.UI.ValueTransformsConfig;
import java.io.File;
import java.util.Hashtable;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;

public class ValueTransformMgr
extends ConfigMgr {
    private final byte[] key;
    private Hashtable<String, ISRFExFormItemValueTransform> valueTransformMap;

    public ValueTransformMgr() {
        byte[] byArray = new byte[8];
        byArray[0] = 1;
        byArray[1] = 9;
        byArray[2] = 9;
        byArray[3] = 7;
        byArray[5] = 7;
        byArray[7] = 1;
        this.key = byArray;
        this.valueTransformMap = new Hashtable();
    }

    public ISRFExFormItemValueTransform GetFormItemValueTransform(String strValueTransformId) {
        Object objValueTransform;
        ISRFExFormItemValueTransform ISRFExFormItemValueTransform2 = this.valueTransformMap.get(strValueTransformId);
        if (ISRFExFormItemValueTransform2 != null) {
            return ISRFExFormItemValueTransform2;
        }
        ValueTransformConfig valueTransformConfig = this.Get(strValueTransformId);
        if (valueTransformConfig != null && (objValueTransform = ObjectHelper.Create(valueTransformConfig.getType())) != null && objValueTransform instanceof ISRFExFormItemValueTransform) {
            ISRFExFormItemValueTransform iFormItemValueTransform = (ISRFExFormItemValueTransform)objValueTransform;
            this.valueTransformMap.put(strValueTransformId, iFormItemValueTransform);
            return iFormItemValueTransform;
        }
        return null;
    }

    public ValueTransformConfig Get(String strValueTransformId) {
        ValueTransformsConfig configs = this.GetValueTransformsConfig();
        if (configs != null) {
            return configs.getValueTransformConfig(strValueTransformId);
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ValueTransformsConfig GetValueTransformsConfig() {
        block12: {
            String strValueTransformsConfigPath = this.GetConfigFilePath("common" + this.strFolderSeperator + this.GetRealPath("VALUETRANSFORM") + ".xml");
            File file = new File(strValueTransformsConfigPath);
            if (file.exists()) {
                long nLastModify = file.lastModified();
                Hashtable hashtable = this.fileList;
                synchronized (hashtable) {
                    Long nCurLastModify;
                    if (this.fileList.containsKey(strValueTransformsConfigPath) && nLastModify == (nCurLastModify = (Long)this.modifydateList.get(strValueTransformsConfigPath))) {
                        return (ValueTransformsConfig)((Object)this.fileList.get(strValueTransformsConfigPath));
                    }
                }
                try {
                    DOMParser parser = new DOMParser();
                    if (this.bEncrypt) {
                        parser.parse(ValueTransformMgr.getContent((String)strValueTransformsConfigPath, (byte[])this.key));
                    } else {
                        parser.parse(strValueTransformsConfigPath);
                    }
                    Document doc = parser.getDocument();
                    ValueTransformsConfig valueTransformsConfig = new ValueTransformsConfig();
                    if (!valueTransformsConfig.LoadConfig(doc.getDocumentElement())) break block12;
                    Hashtable hashtable2 = this.fileList;
                    synchronized (hashtable2) {
                        this.fileList.put(strValueTransformsConfigPath, valueTransformsConfig);
                        this.modifydateList.put(strValueTransformsConfigPath, nLastModify);
                    }
                    return valueTransformsConfig;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        return new ValueTransformsConfig();
    }
}

