/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEGridColService
extends PSDEGridColServiceBase {
    private static final Log log = LogFactory.getLog(PSDEGridColService.class);

    @Override
    protected void onBeforeGetDraftTemp(PSDEGridCol pSDEGridCol) throws Exception {
        super.onBeforeGetDraftTemp(pSDEGridCol);
        String string = pSDEGridCol.getPSDEGridColName();
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.fillPSDEGridColDefaultName(pSDEGridCol);
        }
    }

    protected void fillPSDEGridColDefaultName(PSDEGridCol pSDEGridCol) throws Exception {
        String string;
        int n = 1;
        String string2 = string = pSDEGridCol.getGridColType();
        if (StringHelper.compare((String)string, (String)"DEFGRIDCOLUMN", (boolean)true) == 0) {
            n = 0;
            string2 = pSDEGridCol.getPSDEFName();
            if (StringHelper.isNullOrEmpty((String)string2)) {
                string2 = string;
            }
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return;
        }
        string2 = string2.toLowerCase();
        PSDEGrid pSDEGrid = new PSDEGrid();
        pSDEGrid.setPSDEGridId(pSDEGridCol.getPSDEGridId());
        ArrayList<PSDEGridCol> arrayList = null;
        arrayList = pSDEGrid.getPSDEGridId().indexOf("SRFTEMPKEY:") == 0 ? this.selectTempByPSDEGrid(pSDEGrid) : this.selectByPSDEGrid(pSDEGrid);
        HashMap<String, PSDEGridCol> hashMap = new HashMap<String, PSDEGridCol>();
        Object object = arrayList.iterator();
        while (object.hasNext()) {
            PSDEGridCol pSDEGridCol2 = object.next();
            hashMap.put(pSDEGridCol2.getPSDEGridColName().toLowerCase(), pSDEGridCol2);
        }
        while (true) {
            if (!hashMap.containsKey(object = StringHelper.format((String)"%1$s%2$s", (Object)string2, (Object)(n == 0 ? "" : Integer.valueOf(n))))) break;
            ++n;
        }
        pSDEGridCol.setPSDEGridColName((String)object);
    }

    @Override
    protected void onBeforeCreateTemp(PSDEGridCol pSDEGridCol) throws Exception {
        pSDEGridCol.setLogicName(this.calcPSDEGridColLogicName(pSDEGridCol));
        if (StringHelper.isNullOrEmpty((String)pSDEGridCol.getPSDEGridColName())) {
            this.fillPSDEGridColDefaultName(pSDEGridCol);
        }
        super.onBeforeCreateTemp(pSDEGridCol);
    }

    @Override
    protected void onBeforeUpdateTemp(PSDEGridCol pSDEGridCol) throws Exception {
        pSDEGridCol.setLogicName(this.calcPSDEGridColLogicName(pSDEGridCol));
        super.onBeforeUpdateTemp(pSDEGridCol);
    }

    protected String calcPSDEGridColLogicName(PSDEGridCol pSDEGridCol) throws Exception {
        String string = pSDEGridCol.getGridColType();
        if (StringHelper.compare((String)string, (String)"DEFGRIDCOLUMN", (boolean)true) == 0 && pSDEGridCol.getPSDEF() != null) {
            return pSDEGridCol.getPSDEF().getLogicName();
        }
        return pSDEGridCol.getLogicName();
    }
}

