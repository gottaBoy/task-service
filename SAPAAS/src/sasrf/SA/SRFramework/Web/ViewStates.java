/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Web;

import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

public class ViewStates {
    private Hashtable hashTable = new Hashtable();

    public void Set(String strKey, Object objValue) {
        if (objValue != null) {
            this.hashTable.put(strKey, objValue);
        }
    }

    public Object Get(String strKey) {
        if (this.hashTable.containsKey(strKey)) {
            return this.hashTable.get(strKey);
        }
        return null;
    }

    public String toString() {
        ByteArrayOutputStream byteOutputStream = null;
        ObjectOutputStream objOutput = null;
        try {
            Object objValue;
            Object objName;
            byteOutputStream = new ByteArrayOutputStream();
            objOutput = new ObjectOutputStream(byteOutputStream);
            Integer nCount = 0;
            Enumeration enumeration = this.hashTable.keys();
            while (enumeration.hasMoreElements()) {
                try {
                    objName = enumeration.nextElement();
                    objValue = this.hashTable.get(objName);
                    if (objValue == null) continue;
                    nCount = nCount + 1;
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                }
            }
            objOutput.writeObject(nCount);
            enumeration = this.hashTable.keys();
            while (enumeration.hasMoreElements()) {
                try {
                    objName = enumeration.nextElement();
                    objValue = this.hashTable.get(objName);
                    if (objValue == null) continue;
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
            String strOutput = Base64.encodeBytes(byteOutputStream.toByteArray(), 2);
            return strOutput;
        }
        return "";
    }

    public void fromString(String strValue) {
        this.hashTable.clear();
        if (StringHelper.StringLength(strValue) == 0) {
            return;
        }
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode(strValue));
            ObjectInputStream objInput = new ObjectInputStream(inputStream);
            Object objCount = objInput.readObject();
            if (objCount == null) {
                return;
            }
            Integer nCount = (Integer)objCount;
            while (nCount > 0) {
                try {
                    nCount = nCount - 1;
                    Object objKey = objInput.readObject();
                    Object objValue = objInput.readObject();
                    this.hashTable.put(objKey, objValue);
                }
                catch (Exception ex) {
                    ex.printStackTrace(System.out);
                    break;
                }
            }
            objInput.close();
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
}

