/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.EmbedGridViewPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExDataGridActionHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.ND.Web;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.ND.Ctrl.DataGrid.DeptNDDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDRecycleDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDShareDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.NDShareFolderDataGridActionHelper;
import SA.SRFDA.ND.Ctrl.DataGrid.PersonNDShareDataGridActionHelper;
import SA.SRFDA.ND.Data.NDDisk;
import SA.SRFDA.ND.Data.NDShare;
import SA.SRFDA.ND.Web.NDFolderViewMode;
import SA.SRFDA.ND.Web.SRFDANDWebCTXHelper;
import SA.SRFDA.ND.Web.ViewModel.NDFolderViewModel;
import SA.SRFDA.Web.Default.EmbedGridViewPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExDataGridActionHelper;
import net.sf.json.JSONObject;

public class NDFolderViewPage
extends EmbedGridViewPage {
    private NDFolderViewModel ndFolderViewModel = null;
    private int nFolderViewMode = 1;
    private NDDisk ndDisk = null;
    private NDShare ndShare = null;

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
                    break;
                }
                case 2: {
                    String strNDOwnerId = SRFDANDWebCTXHelper.GetNDOwnerId((ISRFDAWebContext)this.getWebContext());
                    this.ndDisk = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDDisk("DEPT", strNDOwnerId, !this.IsBackEndMode());
                    break;
                }
                case 6: {
                    String strNDDiskId = SRFDANDWebCTXHelper.GetNDDiskId((ISRFDAWebContext)this.getWebContext());
                    this.ndDisk = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDDisk(strNDDiskId, false);
                    break;
                }
                case 7: {
                    String strNDShareId = SRFDANDWebCTXHelper.GetNDShareId((ISRFDAWebContext)this.getWebContext());
                    this.ndShare = SRFDANDWebCTXHelper.GetNDUserModelStorage((ISRFDAWebContext)this.getWebContext()).FindNDShare(strNDShareId, !this.IsBackEndMode());
                    break;
                }
                case 8: {
                    IDEDataCtrl ndDiskDataCtrl;
                    CallResult callResult;
                    String strNDDiskId = SRFDANDWebCTXHelper.GetNDDiskId((ISRFDAWebContext)this.getWebContext());
                    this.ndDisk = new NDDisk();
                    this.ndDisk.setNDDISKID(strNDDiskId);
                    if (!this.IsBackEndMode() && (callResult = (ndDiskDataCtrl = this.GetDEDataCtrl("ND0011")).Get((BaseDataEntity)this.ndDisk)).IsError()) {
                        throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7f51\u7edc\u78c1\u76d8[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strNDDiskId, (Object)callResult.getErrorInfo()));
                    }
                    break;
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
            case 4: {
                this.ndFolderViewModel.setRootPath("\u56de\u6536\u7ad9");
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
                break;
            }
            case 3: {
                this.ndFolderViewModel.setRootPath("\u6211\u7684\u5171\u4eab");
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
                break;
            }
            case 2: 
            case 6: 
            case 8: {
                this.ndFolderViewModel.setRootPath(this.ndDisk.getNDDISKNAME());
                this.ndFolderViewModel.setRootFSOId(this.ndDisk.getNDDISKID());
                break;
            }
            case 7: {
                this.ndFolderViewModel.setRootPath(this.ndShare.getNDSHARENAME());
                this.ndFolderViewModel.setRootFSOId(this.ndShare.getNDSHAREID());
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
            case 2: {
                return new DeptNDDataGridActionHelper();
            }
            case 6: {
                NDShareDataGridActionHelper ndShareDataGridActionHelper = new NDShareDataGridActionHelper();
                ndShareDataGridActionHelper.setNDDisk(this.ndDisk);
                return ndShareDataGridActionHelper;
            }
            case 7: {
                NDShareFolderDataGridActionHelper ndShareFolderDataGridActionHelper = new NDShareFolderDataGridActionHelper();
                ndShareFolderDataGridActionHelper.setNDShare(this.ndShare);
                return ndShareFolderDataGridActionHelper;
            }
            case 8: {
                return new NDDataGridActionHelper();
            }
        }
        return new NDDataGridActionHelper();
    }
}

