/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.IDEFieldDiffItem
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.pscore.srv.util.Inflector
 */
package SA.SRFDA.PS.Core.Database;

import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBSchemeObject;
import SA.SRFDA.PS.Core.IPSModelDiffActionContext;
import SA.SRFDA.PS.Core.IPSModelDiffable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Util.PSModelDiffHelper;
import java.util.ArrayList;
import net.ibizsys.paas.data.IDEFieldDiffItem;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.pscore.srv.util.Inflector;

@PSModelIgnoreMeta
public abstract class PSSysDBSchemeObjectImpl
extends PSObjectImpl
implements IPSSysDBSchemeObject {
    protected IPSSysDBScheme iPSSysDBScheme = null;

    @Override
    public IPSSysDBScheme getPSSysDBScheme() {
        return this.iPSSysDBScheme;
    }

    protected void setPSSysDBScheme(IPSSysDBScheme iPSSysDBScheme) {
        this.iPSSysDBScheme = iPSSysDBScheme;
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

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSysDBScheme().getPSSystem());
    }

    @Override
    public String getDynaModelFilePath() {
        return null;
    }

    @Override
    protected String onGetMOSFolder() {
        if (this.getPSSysDBScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysDBScheme().getMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getModelType()).toLowerCase();
    }

    @Override
    protected String onGetRTMOSFolder() {
        if (this.getPSSysDBScheme() != null) {
            return String.format("%1$s/%2$s", this.getPSSysDBScheme().getRTMOSFilePath(), Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase());
        }
        return Inflector.getInstance().pluralize((Object)this.getRTMOSModelType()).toLowerCase();
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        return this.getPSSysDBScheme();
    }

    @Override
    protected IPSModelObject onGetScopeModel() {
        return this.getPSSysDBScheme();
    }
}

