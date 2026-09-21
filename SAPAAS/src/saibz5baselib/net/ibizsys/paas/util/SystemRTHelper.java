/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.appmodel.AppModelGlobal;
import net.ibizsys.paas.appmodel.IApplicationModel;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.core.IApplication;
import net.ibizsys.paas.core.ISystem;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.sysmodel.ICodeListModel;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.sysmodel.SysModelGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psrt.srv.common.entity.CodeList;
import net.ibizsys.psrt.srv.common.service.CodeListService;

public class SystemRTHelper {
    public static void installAll() throws Exception {
        SystemRTHelper.installCodeList();
        SystemRTHelper.installSystem();
        SystemRTHelper.installApplication();
    }

    public static void installCodeList() throws Exception {
        CodeListService codeListService = (CodeListService)ServiceGlobal.getService(CodeListService.class);
        HashMap<String, ICodeListModel> codeListMap = new HashMap<String, ICodeListModel>();
        Iterator<ICodeList> codeLists = CodeListGlobal.getAllCodelists();
        while (codeLists.hasNext()) {
            ICodeListModel iCodeListModel = (ICodeListModel)codeLists.next();
            if (codeListMap.containsKey(iCodeListModel.getId())) continue;
            codeListMap.put(iCodeListModel.getId(), iCodeListModel);
            if (StringHelper.compare(iCodeListModel.getCodeListType(), "DYNAMIC", true) != 0) continue;
            CodeList codeList = new CodeList();
            codeList.setCodeListId(iCodeListModel.getId());
            codeList.setCodeListName(iCodeListModel.getName());
            codeList.setCLVersion(1);
            codeList.setIsSystem(0);
            codeListService.save(codeList);
        }
    }

    public static void installSystem() throws Exception {
        Iterator<ISystem> sysIt = SysModelGlobal.getAllSystems();
        while (sysIt.hasNext()) {
            ISystemModel iSystemModel = (ISystemModel)sysIt.next();
            iSystemModel.installRTDatas();
        }
    }

    public static void installApplication() throws Exception {
        Iterator<IApplication> apps = AppModelGlobal.getAllApplications();
        while (apps.hasNext()) {
            IApplicationModel iAppModel = (IApplicationModel)apps.next();
            iAppModel.installRTDatas();
        }
    }

    public static void installDBModel(String strInstallDBModels, boolean bIgnoreCheck) throws Exception {
        if (StringHelper.isNullOrEmpty(strInstallDBModels)) {
            Iterator<ISystem> sysIt = SysModelGlobal.getAllSystems();
            while (sysIt.hasNext()) {
                ISystemModel iSystemModel = (ISystemModel)sysIt.next();
                iSystemModel.installDBModel(null, bIgnoreCheck);
            }
        } else {
            String[] parts;
            String[] stringArray = parts = strInstallDBModels.split("[;]");
            int n = parts.length;
            int n2 = 0;
            while (n2 < n) {
                String strPart = stringArray[n2];
                String[] items = strPart.split("[|]");
                String strSystemName = items[0];
                String strVersion = null;
                if (items.length > 1) {
                    strVersion = items[1];
                }
                Iterator<ISystem> sysIt = SysModelGlobal.getAllSystems();
                while (sysIt.hasNext()) {
                    ISystemModel iSystemModel = (ISystemModel)sysIt.next();
                    if (StringHelper.compare(iSystemModel.getName(), strSystemName, true) != 0) continue;
                    iSystemModel.installDBModel(strVersion, bIgnoreCheck);
                    break;
                }
                ++n2;
            }
        }
    }

    public static void installDynaSys() throws Exception {
        Iterator<ISystem> sysIt = SysModelGlobal.getAllSystems();
        while (sysIt.hasNext()) {
            ISystemModel iSystemModel = (ISystemModel)sysIt.next();
            if (iSystemModel.getDynaSystemSetting() == null) continue;
            iSystemModel.getDynaSystemSetting().installAll();
        }
    }
}

