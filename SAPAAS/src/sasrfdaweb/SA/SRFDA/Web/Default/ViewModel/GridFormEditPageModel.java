/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Web.Default.ViewModel;

import SA.SRFDA.Web.Default.ViewModel.EditView2Model;
import SA.SRFDA.Web.ViewModel.DGModel;

public class GridFormEditPageModel
extends EditView2Model {
    protected DGModel dgModel = new DGModel();

    public GridFormEditPageModel() {
        this.RegisterCtrlModel("datagrid", this.dgModel);
    }

    public DGModel getDGModel() {
        return this.dgModel;
    }
}

