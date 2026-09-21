/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.ND.Ctrl.DataGrid;

import SA.SRFDA.ND.Ctrl.DataGrid.NDDataGridActionHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GroupNDDataGridActionHelper
extends NDDataGridActionHelper {
    private static final Log log = LogFactory.getLog(GroupNDDataGridActionHelper.class);

    public GroupNDDataGridActionHelper() {
        this.bRemoveFlagCondition = true;
    }
}

