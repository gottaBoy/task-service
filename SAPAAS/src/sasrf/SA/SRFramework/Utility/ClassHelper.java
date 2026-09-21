/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

public class ClassHelper {
    public static boolean ContainClass(Class objClassInfo, Class classInfo) {
        boolean bInterface = classInfo.isInterface();
        if (!bInterface) {
            if (objClassInfo.getName() == classInfo.getName()) {
                return true;
            }
            if (objClassInfo.getSuperclass() != null) {
                return ClassHelper.ContainClass(objClassInfo.getSuperclass(), classInfo);
            }
            return false;
        }
        Class<?>[] inter = objClassInfo.getInterfaces();
        int i = 0;
        while (i < inter.length) {
            if (inter[i].getName() == classInfo.getName()) {
                return true;
            }
            ++i;
        }
        if (objClassInfo.getSuperclass() != null) {
            return ClassHelper.ContainClass(objClassInfo.getSuperclass(), classInfo);
        }
        return false;
    }
}

