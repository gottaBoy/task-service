/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.controller.IViewController
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.common.entity.PPModel
 *  net.ibizsys.psrt.srv.common.service.PPModelService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.paas.web.jquery.util;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.controller.IViewController;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.PPModel;
import net.ibizsys.psrt.srv.common.service.PPModelService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PortalViewHelper {
    private static PortalViewHelper portalViewHelper = new PortalViewHelper();
    protected ThreadLocal<IViewController> viewControllerLocal = new ThreadLocal();
    private static Log log = LogFactory.getLog(PortalViewHelper.class);
    protected ThreadLocal<PortalViewModel> portalViewModelLocal = new ThreadLocal();

    public static PortalViewHelper getInstance(IViewController iViewController, boolean bEmbed) throws Exception {
        portalViewHelper.setViewController(iViewController);
        return portalViewHelper;
    }

    protected void setViewController(IViewController iViewController) throws Exception {
        this.viewControllerLocal.set(iViewController);
        this.portalViewModelLocal.set(null);
        if (iViewController == null) {
            return;
        }
        PPModel ppModel = new PPModel();
        PPModelService pPModelService = (PPModelService)ServiceGlobal.getService(PPModelService.class, (SessionFactory)iViewController.getSessionFactory());
        String strUserId = WebContext.getCurrent().getCurUserId();
        if (!StringHelper.isNullOrEmpty((String)strUserId)) {
            String strPPModelId = KeyValueHelper.genUniqueId((String)iViewController.getId(), (String)strUserId);
            ppModel.setPPModelId(strPPModelId);
            if (!pPModelService.get((IEntity)ppModel, true)) {
                PPModel defPPModel = new PPModel();
                defPPModel.setPPModelId(KeyValueHelper.genUniqueId((String)iViewController.getId(), (String)"DEFAULT"));
                if (pPModelService.get((IEntity)defPPModel, true)) {
                    defPPModel.copyTo((IDataObject)ppModel, true);
                    ppModel.setPPModelId(strPPModelId);
                    ppModel.setOwnerId(strUserId);
                    pPModelService.create((IEntity)ppModel);
                } else {
                    log.error((Object)StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u95e8\u6237\u9875\u9762[%1$s]\u9ed8\u8ba4\u5e03\u5c40", (Object)iViewController.getTitle()));
                }
            }
        } else {
            ppModel.setPPModelId(KeyValueHelper.genUniqueId((String)iViewController.getId(), (String)"DEFAULT"));
            if (!pPModelService.get((IEntity)ppModel, true)) {
                log.error((Object)StringHelper.format((String)"\u6ca1\u6709\u5b9a\u4e49\u95e8\u6237\u9875\u9762[%1$s]\u9ed8\u8ba4\u5e03\u5c40", (Object)iViewController.getTitle()));
            }
        }
        PortalViewModel portalViewModel = new PortalViewModel();
        String strLayoutModel = ppModel.getPPModel();
        if (StringHelper.isNullOrEmpty((String)strLayoutModel)) {
            this.portalViewModelLocal.set(portalViewModel);
            return;
        }
        HashMap<String, String> ctrlIdMap = new HashMap<String, String>();
        int nLeave = 12;
        String[] parts = strLayoutModel.split("[_]");
        int i = 0;
        while (i < parts.length) {
            String strPart = parts[i];
            String strPos = "";
            int nCol = PortalViewHelper.getColCount(strPart);
            if (nCol < 0 || nCol > 12) {
                nCol = 12;
            }
            if (i == parts.length - 1) {
                nCol = nLeave;
            }
            nLeave -= nCol;
            ArrayList<String> list = null;
            switch (i) {
                case 0: {
                    strPos = "L";
                    portalViewModel.LeftColCount = nCol;
                    list = portalViewModel.LeftColCtrlList;
                    break;
                }
                case 1: {
                    strPos = "C";
                    portalViewModel.CenterColCount = nCol;
                    list = portalViewModel.CenterColCtrlList;
                    break;
                }
                case 2: {
                    strPos = "R";
                    portalViewModel.RightColCount = nCol;
                    list = portalViewModel.RightColCtrlList;
                    break;
                }
            }
            int j = 0;
            while (j < 5) {
                String strFieldName = StringHelper.format((String)"%1$s%2$sPVPartCtrlId", (Object)strPos, (Object)(j + 1));
                String strCtrlId = DataObject.getStringValue((IDataObject)ppModel, (String)strFieldName, (String)"");
                if (!StringHelper.isNullOrEmpty((String)strCtrlId) && !ctrlIdMap.containsKey(strCtrlId)) {
                    ctrlIdMap.put(strCtrlId, "");
                    list.add(strCtrlId);
                }
                ++j;
            }
            ++i;
        }
        this.portalViewModelLocal.set(portalViewModel);
    }

    private static int getColCount(String strPart) {
        if (strPart.indexOf("P") != -1) {
            int nValue = Integer.parseInt(strPart.replace("P", ""));
            if ((nValue /= 10) <= 1) {
                return 1;
            }
            if (nValue <= 4) {
                return nValue;
            }
            if (nValue == 5) {
                return 6;
            }
            return nValue + 2;
        }
        return Integer.parseInt(strPart);
    }

    protected IViewController getViewController() {
        return this.viewControllerLocal.get();
    }

    private PortalViewModel getPortalViewModel() {
        return this.portalViewModelLocal.get();
    }

    public int getLeftColCount() {
        return this.getPortalViewModel().LeftColCount;
    }

    public int getCenterColCount() {
        return this.getPortalViewModel().CenterColCount;
    }

    public int getRightColCount() {
        return this.getPortalViewModel().RightColCount;
    }

    public ArrayList<String> getLeftColCtrls() {
        return this.getPortalViewModel().LeftColCtrlList;
    }

    public ArrayList<String> getCenterColCtrls() {
        return this.getPortalViewModel().CenterColCtrlList;
    }

    public ArrayList<String> getRightColCtrls() {
        return this.getPortalViewModel().RightColCtrlList;
    }

    private class PortalViewModel {
        public int LeftColCount = 9;
        public int CenterColCount = 0;
        public int RightColCount = 3;
        public ArrayList<String> LeftColCtrlList = new ArrayList();
        public ArrayList<String> CenterColCtrlList = new ArrayList();
        public ArrayList<String> RightColCtrlList = new ArrayList();

        private PortalViewModel() {
        }
    }
}

