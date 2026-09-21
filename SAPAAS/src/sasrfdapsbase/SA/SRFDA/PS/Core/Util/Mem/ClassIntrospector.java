/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Util.Mem;

import SA.SRFDA.PS.Core.Util.Mem.ObjectInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public class ClassIntrospector {
    private static final Unsafe unsafe;
    private static final int objectRefSize;
    private static final Map<Class, Integer> primitiveSizes;
    private IdentityHashMap<Object, Boolean> m_visited = new IdentityHashMap(100);

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
            objectRefSize = unsafe.arrayIndexScale(Object[].class);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        primitiveSizes = new HashMap<Class, Integer>(10);
        primitiveSizes.put(Byte.TYPE, 1);
        primitiveSizes.put(Character.TYPE, 2);
        primitiveSizes.put(Integer.TYPE, 4);
        primitiveSizes.put(Long.TYPE, 8);
        primitiveSizes.put(Float.TYPE, 4);
        primitiveSizes.put(Double.TYPE, 8);
        primitiveSizes.put(Boolean.TYPE, 1);
    }

    public ObjectInfo introspect(Object obj) throws IllegalAccessException {
        try {
            ObjectInfo objectInfo = this.introspect(obj, null);
            return objectInfo;
        }
        finally {
            this.m_visited.clear();
        }
    }

    private ObjectInfo introspect(Object obj, Field fld) throws IllegalAccessException {
        ObjectInfo root;
        boolean isPrimitive = fld != null && fld.getType().isPrimitive();
        boolean isRecursive = false;
        if (!isPrimitive) {
            if (this.m_visited.containsKey(obj)) {
                isRecursive = true;
            }
            this.m_visited.put(obj, true);
        }
        Class<?> type = fld == null || obj != null && !isPrimitive ? obj.getClass() : fld.getType();
        int arraySize = 0;
        int baseOffset = 0;
        int indexScale = 0;
        if (type.isArray() && obj != null) {
            baseOffset = unsafe.arrayBaseOffset(type);
            indexScale = unsafe.arrayIndexScale(type);
            arraySize = baseOffset + indexScale * Array.getLength(obj);
        }
        if (fld == null) {
            root = new ObjectInfo("", type.getCanonicalName(), ClassIntrospector.getContents(obj, type), 0, ClassIntrospector.getShallowSize(type), arraySize, baseOffset, indexScale);
        } else {
            int offset = (int)unsafe.objectFieldOffset(fld);
            root = new ObjectInfo(fld.getName(), type.getCanonicalName(), ClassIntrospector.getContents(obj, type), offset, ClassIntrospector.getShallowSize(type), arraySize, baseOffset, indexScale);
        }
        if (!isRecursive && obj != null) {
            if (ClassIntrospector.isObjectArray(type)) {
                Object[] ar;
                Object[] objectArray = ar = (Object[])obj;
                int n = ar.length;
                int n2 = 0;
                while (n2 < n) {
                    Object item = objectArray[n2];
                    if (item != null) {
                        root.addChild(this.introspect(item, null));
                    }
                    ++n2;
                }
            } else {
                for (Field field : ClassIntrospector.getAllFields(type)) {
                    if ((field.getModifiers() & 8) != 0) continue;
                    field.setAccessible(true);
                    root.addChild(this.introspect(field.get(obj), field));
                }
            }
        }
        root.sort();
        return root;
    }

    private static List<Field> getAllFields(Class type) {
        if (type.isPrimitive()) {
            return Collections.emptyList();
        }
        Class cur = type;
        ArrayList<Field> res = new ArrayList<Field>(10);
        while (true) {
            Collections.addAll(res, cur.getDeclaredFields());
            if (cur == Object.class) break;
            cur = cur.getSuperclass();
        }
        return res;
    }

    private static boolean isObjectArray(Class type) {
        if (!type.isArray()) {
            return false;
        }
        return type != byte[].class && type != boolean[].class && type != char[].class && type != short[].class && type != int[].class && type != long[].class && type != float[].class && type != double[].class;
    }

    private static String getContents(Object val, Class type) {
        if (val == null) {
            return "null";
        }
        if (type.isArray()) {
            if (type == byte[].class) {
                return Arrays.toString((byte[])val);
            }
            if (type == boolean[].class) {
                return Arrays.toString((boolean[])val);
            }
            if (type == char[].class) {
                return Arrays.toString((char[])val);
            }
            if (type == short[].class) {
                return Arrays.toString((short[])val);
            }
            if (type == int[].class) {
                return Arrays.toString((int[])val);
            }
            if (type == long[].class) {
                return Arrays.toString((long[])val);
            }
            if (type == float[].class) {
                return Arrays.toString((float[])val);
            }
            if (type == double[].class) {
                return Arrays.toString((double[])val);
            }
            return Arrays.toString((Object[])val);
        }
        return val.toString();
    }

    private static int getShallowSize(Class type) {
        if (type.isPrimitive()) {
            Integer res = primitiveSizes.get(type);
            return res != null ? res : 0;
        }
        return objectRefSize;
    }
}

