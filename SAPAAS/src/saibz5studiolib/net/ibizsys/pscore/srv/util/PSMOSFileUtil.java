/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSMOSFileUtil {
    private static final Log log = LogFactory.getLog(PSMOSFileUtil.class);
    static Map<String, Integer> MOSLevelMap = new HashMap<String, Integer>();

    public static void addAll(List<PSMOSFile> list, PSMOSFile[] pSMOSFileArray) {
        if (pSMOSFileArray != null) {
            for (PSMOSFile pSMOSFile : pSMOSFileArray) {
                list.add(pSMOSFile);
            }
        }
    }

    public static PSMOSFile[] append(PSMOSFile[] pSMOSFileArray, PSMOSFile[] pSMOSFileArray2) {
        if (pSMOSFileArray == null && pSMOSFileArray2 == null) {
            return null;
        }
        if (pSMOSFileArray != null && pSMOSFileArray2 == null) {
            return pSMOSFileArray;
        }
        if (pSMOSFileArray == null && pSMOSFileArray2 != null) {
            return pSMOSFileArray2;
        }
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        PSMOSFileUtil.addAll(arrayList, pSMOSFileArray);
        PSMOSFileUtil.addAll(arrayList, pSMOSFileArray2);
        return arrayList.toArray(new PSMOSFile[arrayList.size()]);
    }

    public static int compare(PSMOSFile pSMOSFile, PSMOSFile pSMOSFile2) {
        try {
            int n = DataObject.getIntegerValue((Object)MOSLevelMap.get(pSMOSFile.getFileTag()), (Integer)9999);
            int n2 = DataObject.getIntegerValue((Object)MOSLevelMap.get(pSMOSFile2.getFileTag()), (Integer)9999);
            if (n != n2) {
                return Integer.valueOf(n).compareTo(n2);
            }
            return pSMOSFile.getPSMOSFileName().compareTo(pSMOSFile2.getPSMOSFileName());
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return 0;
        }
    }

    public static PSMOSFile[] sort(PSMOSFile[] pSMOSFileArray) {
        if (pSMOSFileArray == null || pSMOSFileArray.length == 0) {
            return pSMOSFileArray;
        }
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        PSMOSFileUtil.addAll(arrayList, pSMOSFileArray);
        Collections.sort(arrayList, new Comparator<PSMOSFile>(){

            @Override
            public int compare(PSMOSFile pSMOSFile, PSMOSFile pSMOSFile2) {
                return PSMOSFileUtil.compare(pSMOSFile, pSMOSFile2);
            }
        });
        return arrayList.toArray(pSMOSFileArray);
    }

    static {
        MOSLevelMap.put("MODEL", 100);
        MOSLevelMap.put("LINK", 200);
        MOSLevelMap.put("DR", 300);
        MOSLevelMap.put("GROUP", 400);
    }
}

