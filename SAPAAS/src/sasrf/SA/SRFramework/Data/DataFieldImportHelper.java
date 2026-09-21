/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class DataFieldImportHelper
extends XMLConfig {
    public static String TAG_FIELD = "FIELD";
    public static String TAG_NAME = "NAME";
    public static String TAG_VALUE = "VALUE";
    public static String TAG_ISNULL = "ISNULL";
    private String strFieldName = "";
    private Object objValue = null;
    private boolean bIsNull = false;

    public String getFieldName() {
        return this.strFieldName;
    }

    public Object getValue() {
        return this.objValue;
    }

    public boolean getIsNull() {
        return this.bIsNull;
    }

    @Override
    protected void OnSetProperty(String strName, String strValue) {
        if (StringHelper.Compare(strName, TAG_NAME, true) == 0) {
            this.strFieldName = strValue;
            return;
        }
        if (StringHelper.Compare(strName, TAG_ISNULL, true) == 0) {
            this.bIsNull = this.GetExtValue(strValue, this.bIsNull);
            return;
        }
        if (StringHelper.Compare(strName, TAG_VALUE, true) == 0) {
            this.LoadObject(strValue);
            return;
        }
        super.OnSetProperty(strName, strValue);
    }

    private void LoadObject(String strValue) {
        try {
            if (StringHelper.Length(strValue) == 0) {
                return;
            }
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode(strValue));
            ObjectInputStream objInput = new ObjectInputStream(inputStream);
            this.objValue = objInput.readObject();
            objInput.close();
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
}

