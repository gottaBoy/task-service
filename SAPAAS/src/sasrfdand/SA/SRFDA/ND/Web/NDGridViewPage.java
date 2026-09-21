/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Default.GridViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.WebEx.SRFExDataGridActionHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.ND.Ctrl.DataGrid.AllNDShareDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDRecycleDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.PersonNDShareDataGridActionHelper;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Web.NDFolderViewMode;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.ND.Web.ViewModel.NDFolderViewModel;
import SA.SRFDA.Web.Default.GridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import net.sf.json.JSONObject;

public class NDGridViewPage
extends GridViewPage {
    private NDFolderViewModel ndFolderViewModel = null;
    private int nFolderViewMode = 4;
    private NDDisk ndDisk = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        try {
            this.nFolderViewMode = this.OnGetFolderViewMode();
            switch (this.nFolderViewMode) {
                case 1: 
                case 3: 
                case 4: {
                    this.ndDisk = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDDisk(!this.IsBackEndMode());
                }
            }
        }
        catch (Exception ex) {
            this.PageLog((Object)this, 1, ex.getMessage(), ex);
            return false;
        }
        return true;
    }

    protected int OnGetFolderViewMode() {
        String strViewMode = this.getPageParam("PAGE.FOLDERVIEWMODE", "PERSON");
        return NDFolderViewMode.ParseFolderViewMode(strViewMode);
    }

    protected PageModel CreatePageModel() {
        return new NDFolderViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.ndFolderViewModel = (NDFolderViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        if (!super.OnFillPageModel(jsonObject)) {
            return false;
        }
        switch (this.nFolderViewMode) {
            case 1: {
                this.ndFolderViewModel.setRootPath("\u6211\u7684\u7f51\u76d8");
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
                break;
            }
            case 3: {
                this.ndFolderViewModel.setRootPath("\u6211\u7684\u5171\u4eab");
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
                break;
            }
            case 4: {
                this.ndFolderViewModel.setRootPath("\u56de\u6536\u7ad9");
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
            }
        }
        this.ndFolderViewModel.setFolderPath("");
        return true;
    }

    protected SRFExDataGridActionHelper getDataGridActionHelper(String strDataGridId) {
        switch (this.nFolderViewMode) {
            case 1: {
                return new NDDataGridActionHelper();
            }
            case 4: {
                return new NDRecycleDataGridActionHelper();
            }
            case 3: {
                return new PersonNDShareDataGridActionHelper();
            }
            case 5: {
                return new AllNDShareDataGridActionHelper();
            }
        }
        return new NDDataGridActionHelper();
    }
}

