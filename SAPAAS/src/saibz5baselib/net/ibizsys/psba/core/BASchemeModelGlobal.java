/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psba.core;

import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psba.core.IBASchemeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BASchemeModelGlobal {
    private static final Log log = LogFactory.getLog(BASchemeModelGlobal.class);
    private static HashMap<String, IBASchemeModel> baSchemeModelMap = new HashMap();

    public static void registerBASchemeModel(String strBASchemeModelClsType, IBASchemeModel iBASchemeModel) {
        baSchemeModelMap.put(strBASchemeModelClsType, iBASchemeModel);
        baSchemeModelMap.put(iBASchemeModel.getId(), iBASchemeModel);
    }

    public static IBASchemeModel getBASchemeModel(Class cls) throws Exception {
        return BASchemeModelGlobal.getBASchemeModel(cls.getCanonicalName());
    }

    public static IBASchemeModel getBASchemeModel(String strBASchemeModelClsType) throws Exception {
        IBASchemeModel iBASchemeModel = baSchemeModelMap.get(strBASchemeModelClsType);
        if (iBASchemeModel == null) {
            throw new Exception(StringHelper.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5927\u6570\u636e\u67b6\u6784\u6a21\u578b[%1$s]", strBASchemeModelClsType));
        }
        return iBASchemeModel;
    }
}

