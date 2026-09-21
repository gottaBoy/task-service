/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.StringHelper;
import org.w3c.dom.Node;

public class DataImportHelper
extends XMLConfig {
    public static String TAG_DATATABLE = "DATATABLE";
    public static String TAG_DATAROW = "DATAROW";
    public static String TAG_FIELD = "FIELD";
    public static String TAG_NAME = "NAME";
    public static String TAG_VALUE = "VALUE";
    public static String TAG_ISNULL = "ISNULL";

    @Override
    public void OnLoadNode(String strName, Node xmlNode) {
        if (StringHelper.Compare(strName, TAG_DATAROW, true) == 0) {
            return;
        }
        super.OnLoadNode(strName, xmlNode);
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        super.OnSetProperty(strName, strValue);
    }
}

