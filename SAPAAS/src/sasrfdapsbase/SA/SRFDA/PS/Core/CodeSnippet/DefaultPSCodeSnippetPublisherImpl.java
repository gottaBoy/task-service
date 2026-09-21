/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.CodeSnippet;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationObject;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntityObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSCodeSnippetPublisherImplBase;
import java.util.HashMap;

public class DefaultPSCodeSnippetPublisherImpl
extends PSCodeSnippetPublisherImplBase {
    private IPSObject iPSObject = null;

    @Override
    protected IPSGenerateCodeResult onGenerateCode(IPSObject iPSObject) throws Exception {
        this.iPSObject = iPSObject;
        return super.onGenerateCode(iPSObject);
    }

    @Override
    protected void onFillGenerateCodeParams(String strObjType, Object obj, HashMap<String, Object> params) throws Exception {
        IPSSystem iPSSystem = null;
        IPSAppView iPSAppView = null;
        IPSApplication iPSApplication = null;
        IPSDataEntity iPSDataEntity = null;
        IPSAppDataEntity iPSAppDataEntity = null;
        if (this.iPSObject instanceof IPSAppView) {
            IPSAppDEView iPSAppDEView;
            iPSAppView = (IPSAppView)this.iPSObject;
            if (this.iPSObject instanceof IPSAppDEView && (iPSAppDEView = (IPSAppDEView)iPSAppView).getPSDataEntity() != null) {
                iPSDataEntity = iPSAppDEView.getPSDataEntity();
            }
            iPSApplication = iPSAppView.getPSApplication();
            iPSSystem = iPSAppView.getPSSystem();
        } else if (this.iPSObject instanceof IPSAppDataEntity) {
            iPSAppDataEntity = (IPSAppDataEntity)this.iPSObject;
            iPSApplication = iPSAppDataEntity.getPSApplication();
            iPSSystem = iPSApplication.getPSSystem();
            iPSDataEntity = iPSAppDataEntity.getPSDE();
        } else if (this.iPSObject instanceof IPSSystem) {
            iPSSystem = (IPSSystem)this.iPSObject;
        } else if (this.iPSObject instanceof IPSSysSFPub) {
            iPSSystem = ((IPSSysSFPub)this.iPSObject).getPSSystem();
        } else if (this.iPSObject instanceof IPSDataEntityObject) {
            iPSDataEntity = ((IPSDataEntityObject)this.iPSObject).getPSDataEntity();
        } else if (this.iPSObject instanceof IPSApplicationObject) {
            iPSApplication = ((IPSApplicationObject)this.iPSObject).getPSApplication();
        } else if (this.iPSObject instanceof IPSSystemObject) {
            iPSSystem = ((IPSSystemObject)this.iPSObject).getPSSystem();
        }
        if (iPSAppView != null) {
            params.put("appview", iPSAppView);
            if (iPSApplication == null) {
                iPSApplication = iPSAppView.getPSApplication();
            }
        }
        if (iPSDataEntity != null) {
            params.put("de", iPSDataEntity);
            if (iPSSystem == null) {
                iPSSystem = iPSDataEntity.getPSSystem();
            }
        }
        if (iPSApplication != null) {
            params.put("app", iPSApplication);
            if (iPSSystem == null) {
                iPSSystem = iPSApplication.getPSSystem();
            }
        }
        if (iPSSystem != null) {
            params.put("sys", iPSSystem);
        }
        super.onFillGenerateCodeParams(strObjType, obj, params);
    }

    @Override
    protected void onClose() {
        this.iPSObject = null;
        super.onClose();
    }
}

