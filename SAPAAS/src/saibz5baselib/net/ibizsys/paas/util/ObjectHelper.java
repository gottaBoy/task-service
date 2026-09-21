/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ObjectHelper {
    private static final Log log = LogFactory.getLog(ObjectHelper.class);

    public static Object create(String strType) throws Exception {
        return Class.forName(strType).newInstance();
    }

    public static Object create(Class classType) throws Exception {
        return classType.newInstance();
    }

    public byte[] toByteArray(Object obj) throws Exception {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        }
        catch (IOException ex) {
            if (oos != null) {
                oos.close();
            }
            bos.close();
            throw ex;
        }
        return bytes;
    }

    public Object toObject(byte[] bytes) throws Exception {
        Object obj = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        }
        catch (IOException ex) {
            if (ois != null) {
                ois.close();
            }
            if (bis != null) {
                bis.close();
            }
            throw ex;
        }
        catch (ClassNotFoundException ex) {
            if (ois != null) {
                ois.close();
            }
            if (bis != null) {
                bis.close();
            }
            throw ex;
        }
        return obj;
    }
}

