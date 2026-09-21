/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DESubWF
 *  SA.SRFDA.Ctrl.IDEHelper
 *  SA.SRFramework.Utility.StringHelper
 *  SRFWF.Model.WFParallelSubWFConfig
 */
package SA.SRFDA.WF.Ctrl;

import SA.SRFDA.Ctrl.Data.DESubWF;
import SA.SRFDA.Ctrl.IDEHelper;
import SA.SRFramework.Utility.StringHelper;
import SRFWF.Model.WFParallelSubWFConfig;
import java.util.Vector;

public class WFHelper {
    public static void GetDESubWFList(IDEHelper iDEHelper, WFParallelSubWFConfig parallelSubWFConfig, Vector<DESubWF> deSubWFList) throws Exception {
        DESubWF deSubWF;
        if (parallelSubWFConfig.isEnableSubWF()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF2()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId2());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId2()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF3()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId3());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId3()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF4()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId4());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId4()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF5()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId5());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId5()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF6()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId6());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId6()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF7()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId7());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId7()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF8()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId8());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId8()));
            }
        }
        if (parallelSubWFConfig.isEnableSubWF9()) {
            deSubWF = iDEHelper.GetDESubWF(parallelSubWFConfig.getDESubWFId9());
            if (deSubWF != null) {
                deSubWFList.add(deSubWF);
            } else {
                throw new Exception(StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53\u5b50\u6d41\u7a0b[%1$s]", (Object)parallelSubWFConfig.getDESubWFId9()));
            }
        }
    }
}

