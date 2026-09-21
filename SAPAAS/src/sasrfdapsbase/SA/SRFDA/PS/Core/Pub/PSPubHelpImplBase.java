/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSObjectImpl2;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherMacro;
import SA.SRFDA.PS.Core.Pub.IPSCodePublisherParam;
import SA.SRFDA.PS.Core.Pub.IPSPubHelp;
import SA.SRFDA.PS.Core.Pub.IPSPubObj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class PSPubHelpImplBase
extends PSObjectImpl2
implements IPSPubHelp {
    private IPSModelObject iPSObject = null;
    private IPSPubObj iPSPubObj = null;
    private Map<String, IPSCodePublisherParam> params = null;
    private Map<String, IPSCodePublisherMacro> macros = null;

    public PSPubHelpImplBase(IPSModelObject iPSObject, IPSPubObj iPSPubObj, Map<String, IPSCodePublisherParam> params) {
        this.iPSObject = iPSObject;
        this.iPSPubObj = iPSPubObj;
        this.setId(iPSObject.getId());
        this.setName(this.getTarget());
        this.params = params;
        HashMap<String, String> macroMap = new HashMap<String, String>();
        iPSPubObj.fillPublisherMacros(macroMap);
        if (macroMap.size() > 0) {
            this.macros = new HashMap<String, IPSCodePublisherMacro>();
            for (Map.Entry entry : macroMap.entrySet()) {
                IPSCodePublisherMacro iPSCodePublisherMacro = this.createPSCodePublisherMacro((String)entry.getKey(), (String)entry.getValue());
                if (iPSCodePublisherMacro == null) continue;
                this.macros.put(iPSCodePublisherMacro.getKey(), iPSCodePublisherMacro);
            }
        }
    }

    protected abstract IPSCodePublisherMacro createPSCodePublisherMacro(String var1, String var2);

    @Override
    @PSModelRTMeta(name="\u53d1\u5e03\u76ee\u6807", order=100)
    public String getTarget() {
        return this.iPSPubObj.getTarget();
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSObject.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(name="\u5185\u7f6e\u53c2\u6570\u96c6\u5408", order=120)
    public Iterator<IPSCodePublisherParam> getPSCodePublisherParams() {
        if (this.params == null || this.params.size() == 0) {
            return null;
        }
        return this.params.values().iterator();
    }

    @Override
    @PSModelRTMeta(name="\u8def\u5f84\u53d8\u91cf\u96c6\u5408", order=110)
    public Iterator<IPSCodePublisherMacro> getPSCodePublisherMacros() {
        if (this.macros == null || this.macros.size() == 0) {
            return null;
        }
        return this.macros.values().iterator();
    }

    @Override
    public String getModelId() {
        return this.iPSObject.getModelId();
    }

    public IPSModelObject getPSModelObject() {
        return this.iPSObject;
    }
}

