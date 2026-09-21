/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;

public class PSImportHelper {
    private static ThreadLocal<ArrayList<PSImportHelper>> currentImportHelperList = new ThreadLocal();
    private HashMap<String, ArrayList<String>> catImportMap = new HashMap();

    public void register(String strImport) {
        this.register("", strImport);
    }

    public void register(String strCat, String strImport) {
        if (strImport == null) {
            return;
        }
        if (StringHelper.isNullOrEmpty((String)(strImport = strImport.trim()))) {
            return;
        }
        ArrayList<String> list = this.catImportMap.get(strCat);
        if (list == null) {
            list = new ArrayList();
            this.catImportMap.put(strCat, list);
        }
        if (!list.contains(strImport)) {
            list.add(strImport);
        }
    }

    public Iterator<String> getCats() {
        return this.catImportMap.keySet().iterator();
    }

    public ArrayList<String> getList() {
        return this.getList("");
    }

    public ArrayList<String> getList(String strCat) {
        ArrayList<String> list = this.catImportMap.get(strCat);
        return list;
    }

    public static int addHelper(PSImportHelper psImportHelper) {
        ArrayList<PSImportHelper> list = currentImportHelperList.get();
        if (list == null) {
            list = new ArrayList();
            currentImportHelperList.set(list);
        }
        list.add(0, psImportHelper);
        return list.size();
    }

    public static int releaseHelper() {
        return PSImportHelper.releaseHelper(true);
    }

    public static int releaseHelper(boolean bMerge) {
        ArrayList<PSImportHelper> list = currentImportHelperList.get();
        if (list == null) {
            return 0;
        }
        if (list.size() > 0) {
            PSImportHelper curPSImportHelper = list.remove(0);
            if (bMerge && list.size() > 0) {
                PSImportHelper lastPSImportHelper = list.get(0);
                Iterator<String> cats = curPSImportHelper.getCats();
                if (cats != null) {
                    while (cats.hasNext()) {
                        String strCat = cats.next();
                        ArrayList<String> importList = curPSImportHelper.getList(strCat);
                        if (importList == null || importList.size() <= 0) continue;
                        for (String strImport : importList) {
                            lastPSImportHelper.register(strCat, strImport);
                        }
                    }
                }
            }
        }
        return list.size();
    }

    public static PSImportHelper getCurrent() {
        ArrayList<PSImportHelper> list = currentImportHelperList.get();
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }
}

