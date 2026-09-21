/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.appmodel.IAppViewModel
 *  net.ibizsys.paas.appmodel.vue.VueAppPFHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.ssdyna.appmodel.IDynaAppPFHelper
 *  net.ibizsys.ssdyna.appmodel.IDynaAppViewModel
 */
package net.ibizsys.ssdyna.appmodel;

import java.util.HashMap;
import java.util.Map;
import net.ibizsys.model.pub.vue2.PSVue2FileNameMethod;
import net.ibizsys.paas.appmodel.IAppViewModel;
import net.ibizsys.paas.appmodel.vue.VueAppPFHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.ssdyna.appmodel.IDynaAppPFHelper;
import net.ibizsys.ssdyna.appmodel.IDynaAppViewModel;

public class Vue3AppPFHelper
extends VueAppPFHelper
implements IDynaAppPFHelper {
    public String getAppViewUrl(IAppViewModel iAppViewModel, Map<String, String> params) throws Exception {
        if (iAppViewModel instanceof IDynaAppViewModel) {
            if (params == null) {
                params = new HashMap<String, String>();
            }
            params.put("SRFVIEWID", iAppViewModel.getId());
        }
        String strUrlParams = "";
        if (params != null && params.size() > 0) {
            HashMap<String, String> params2 = new HashMap<String, String>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                params2.put(entry.getKey().toLowerCase(), entry.getValue());
            }
            strUrlParams = WebUtility.getQueryString(params2, (String)";");
        }
        if (StringHelper.isNullOrEmpty((String)strUrlParams)) {
            return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getModuleName()), (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()), (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()), (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()));
        }
        return StringHelper.format((String)"/pages/%1$s/%2$s/%3$s.html#/%4$s", (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getModuleName()), (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()), (Object)PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName()), (Object)(String.valueOf(PSVue2FileNameMethod.replaceFullName(iAppViewModel.getName())) + "/" + strUrlParams));
    }
}

