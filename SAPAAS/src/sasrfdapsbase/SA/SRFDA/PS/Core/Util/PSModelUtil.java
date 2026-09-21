/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.IPSModelSortable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.util.StringHelper;

public class PSModelUtil {
    public static <T> Collection<T> sort(Map<String, T> map, Class<T> cls) {
        ArrayList<T> list = new ArrayList<T>();
        list.addAll(map.values());
        PSModelUtil.sort(list);
        return list;
    }

    public static void sort(List<?> list) {
        Collections.sort(list, new Comparator<Object>(){

            @Override
            public int compare(Object o1, Object o2) {
                int nRet = 0;
                if (o1 instanceof IPSModelSortable && o2 instanceof IPSModelSortable) {
                    IPSModelSortable i1 = (IPSModelSortable)o1;
                    IPSModelSortable i2 = (IPSModelSortable)o2;
                    nRet = new Integer(i1.getOrderValue()).compareTo(i2.getOrderValue());
                    if (nRet != 0) {
                        return nRet;
                    }
                    nRet = StringHelper.compare((String)i1.getCodeName(), (String)i2.getCodeName(), (boolean)false);
                    if (nRet != 0) {
                        return nRet;
                    }
                    nRet = StringHelper.compare((String)i1.getName(), (String)i2.getName(), (boolean)false);
                    return nRet;
                }
                return nRet;
            }
        });
    }

    public static boolean isEmpty(Iterator<?> it) {
        if (it == null) {
            return true;
        }
        return it.hasNext();
    }
}

