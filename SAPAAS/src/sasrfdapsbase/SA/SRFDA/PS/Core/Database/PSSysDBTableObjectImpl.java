/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBTable;
import SA.SRFDA.PS.Core.Database.IPSSysDBTableObject;
import SA.SRFDA.PS.Core.Database.PSSysDBSchemeObjectImpl;
import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Util.PSModelDiffHelper;
import java.util.ArrayList;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.pscore.srv.util.Inflector;

@PSModelIgnoreMeta
public abstract class PSSysDBTableObjectImpl
extends PSSysDBSchemeObjectImpl
implements IPSSysDBTableObject {
    protected IPSSysDBTable iPSSysDBTable = null;

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8868")
    public IPSSysDBTable getPSSysDBTable() {
        return this.iPSSysDBTable;
    }

    protected void setPSSysDBTable(IPSSysDBTable iPSSysDBTable) {
        this.iPSSysDBTable = iPSSysDBTable;
        if (this.iPSSysDBTable != null) {
            this.setPSSysDBScheme(this.iPSSysDBTable.getPSSysDBScheme());
        } else {
            this.setPSSysDBScheme(null);
        }
    }

    @Override
    public String getPSSysModelInstId() {
        return this.getPSSysDBScheme().getPSSysModelInstId();
    }

    @Override
    public int diff(IPSModelDiffActionContext iPSModelDiffActionContext, Object dstModel) throws Exception {
        IPSModelDiffable dstPSModelDiffable = (IPSModelDiffable)dstModel;
        ArrayList<IDEFieldDiffItem> list = PSModelDiffHelper.getDEDataDiffItems(DEModelGlobal.getDEModel((String)this.getModelType()), this.getModelData(), dstPSModelDiffable.getModelData(), false);
        if (list == null || list.size() == 0) {
            return 0;
        }
        iPSModelDiffActionContext.addDiffItem(null, this, list);
        return 1;
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysDBTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysDBTable().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysDBTable() != null) {
            return String.format("%1$s/%2$s", this.getPSSysDBTable().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysDBTable();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysDBTable();
    }
}

