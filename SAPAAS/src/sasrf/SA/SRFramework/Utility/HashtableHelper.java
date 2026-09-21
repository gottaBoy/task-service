/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashtableHelper {
    public static String ToString(Hashtable hashTable) {
        String strOutput = "";
        try {
            Enumeration enumeration = hashTable.keys();
            while (enumeration.hasMoreElements()) {
                try {
                    Object objName = enumeration.nextElement();
                    Object objValue = hashTable.get(objName);
                    if (objValue == null) continue;
                    strOutput = String.valueOf(strOutput) + objName.toString();
                    strOutput = String.valueOf(strOutput) + "\t";
                    strOutput = String.valueOf(strOutput) + objValue.toString();
                    strOutput = String.valueOf(strOutput) + "\n";
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        if (StringHelper.Length(strOutput) != 0) {
            try {
                strOutput = URLEncoder.encode(strOutput, "UTF-8");
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
            }
            return strOutput;
        }
        return "";
    }

    public static Hashtable FromString(String strValue) {
        Hashtable<Object, Object> hashTable = new Hashtable<Object, Object>();
        if (StringHelper.StringLength(strValue) == 0) {
            return hashTable;
        }
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode(strValue));
            ObjectInputStream objInput = new ObjectInputStream(inputStream);
            try {
                while (true) {
                    Object objKey = objInput.readObject();
                    Object objValue = objInput.readObject();
                    hashTable.put(objKey, objValue);
                }
            }
            catch (Exception ex) {
                ex.printStackTrace(System.out);
                objInput.close();
            }
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
        return hashTable;
    }
}

