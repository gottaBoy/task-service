/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jfree.data.category.DefaultCategoryDataset
 */
package SA.SRFramework.Report.Data;

import SA.SRFramework.Data.BaseXYZDataHelper;
import SA.SRFramework.Data.DataItem;
import org.jfree.data.category.DefaultCategoryDataset;

public class DefaultCategoryDatasetHelper
extends BaseXYZDataHelper {
    private DefaultCategoryDataset defaultCategoryDataset;

    public DefaultCategoryDatasetHelper() {
        this.defaultCategoryDataset = new DefaultCategoryDataset();
    }

    public DefaultCategoryDatasetHelper(DefaultCategoryDataset value) {
        this.defaultCategoryDataset = value;
    }

    public DefaultCategoryDataset getDataSet() {
        return this.defaultCategoryDataset;
    }

    @Override
    public void DataBind() throws Exception {
        super.DataBind();
        for (Object objItem : this.itemList) {
            DataItem dataItem = (DataItem)objItem;
            this.defaultCategoryDataset.addValue(Double.parseDouble(dataItem.getZ()), (Comparable)((Object)dataItem.getY()), (Comparable)((Object)dataItem.getX()));
        }
    }
}

