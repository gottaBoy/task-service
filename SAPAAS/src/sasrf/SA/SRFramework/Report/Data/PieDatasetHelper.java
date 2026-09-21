/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.data.general.DefaultPieDataset
 */
package SA.SRFramework.Report.Data;

import SA.SRFramework.Data.BaseXYDataHelper;
import SA.SRFramework.Data.DataItem;
import org.jfree.data.general.DefaultPieDataset;

public class PieDatasetHelper
extends BaseXYDataHelper {
    private DefaultPieDataset pieDataset = null;

    public PieDatasetHelper() {
        this.pieDataset = new DefaultPieDataset();
    }

    public PieDatasetHelper(DefaultPieDataset value) {
        this.pieDataset = value;
    }

    @Override
    public void DataBind() throws Exception {
        super.DataBind();
        for (Object objItem : this.itemList) {
            DataItem dataItem = (DataItem)objItem;
            this.pieDataset.setValue((Comparable)((Object)dataItem.getX()), Double.parseDouble(dataItem.getY()));
        }
    }

    public DefaultPieDataset getDataSet() {
        return this.pieDataset;
    }
}

