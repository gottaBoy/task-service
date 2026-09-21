/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Plugin;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.DEField.IPSDEFieldObject;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Plugin.IPSModelCheckPlugin;
import SA.SRFDA.PS.Core.Plugin.PSModelCheckPluginContextImpl;
import SA.SRFDA.PS.Core.Plugin.PSModelPluginImpl;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import net.ibizsys.paas.util.StringHelper;

public class PSModelCheckPluginImpl
extends PSModelPluginImpl
implements IPSModelCheckPlugin {
    protected PSModelCheckPluginContextImpl psModelCheckPluginContextImpl = null;
    protected ScriptEngine engine = null;

    @Override
    protected void onInit() throws Exception {
        this.psModelCheckPluginContextImpl = new PSModelCheckPluginContextImpl();
        this.psModelCheckPluginContextImpl.init(this);
        String strCode = this.psModelPlugin.getJSCODE();
        if (!StringHelper.isNullOrEmpty((String)strCode)) {
            ScriptEngineManager sem = new ScriptEngineManager();
            this.engine = sem.getEngineByName("javascript");
            this.engine.put("ctx", this.psModelCheckPluginContextImpl);
            this.engine.eval(strCode);
        }
        super.onInit();
    }

    @Override
    public int check(IPSModelObject iPSModelObject) throws Exception {
        if (this.engine != null) {
            IPSSystem iPSSystem = null;
            IPSDataEntity iPSDataEntity = null;
            IPSApplication iPSApplication = null;
            this.psModelCheckPluginContextImpl.reset();
            if (iPSModelObject instanceof IPSSystemObject) {
                iPSSystem = ((IPSSystemObject)iPSModelObject).getPSSystem();
            }
            if (iPSModelObject instanceof IPSDataEntityObject) {
                iPSDataEntity = ((IPSDataEntityObject)iPSModelObject).getPSDataEntity();
            }
            if (iPSModelObject instanceof IPSDEFieldObject) {
                iPSDataEntity = ((IPSDEFieldObject)iPSModelObject).getPSDEField().getPSDataEntity();
            }
            if (iPSModelObject instanceof IPSDataEntity) {
                iPSDataEntity = (IPSDataEntity)iPSModelObject;
            }
            if (iPSModelObject instanceof IPSApplicationObject) {
                iPSApplication = ((IPSApplicationObject)iPSModelObject).getPSApplication();
            }
            if (iPSModelObject instanceof IPSApplication) {
                iPSApplication = (IPSApplication)iPSModelObject;
            }
            if (iPSDataEntity != null) {
                iPSSystem = iPSDataEntity.getPSSystem();
            }
            if (iPSApplication != null) {
                iPSSystem = iPSApplication.getPSSystem();
            }
            if (iPSSystem == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u6a21\u578b\u7c7b\u578b[%1$s]\u83b7\u53d6\u7cfb\u7edf\u6a21\u578b\u5bf9\u8c61"));
            }
            this.psModelCheckPluginContextImpl.setPSSystem(iPSSystem);
            this.psModelCheckPluginContextImpl.setPSDataEntity(iPSDataEntity);
            this.psModelCheckPluginContextImpl.setPSApplication(iPSApplication);
            this.psModelCheckPluginContextImpl.setPSModelObject(iPSModelObject);
            Invocable jsInvoke = (Invocable)((Object)this.engine);
            jsInvoke.invokeFunction("check", iPSModelObject);
        }
        return 0;
    }
}

