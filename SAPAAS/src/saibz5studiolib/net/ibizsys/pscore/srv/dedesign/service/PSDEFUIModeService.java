/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.springframework.stereotype.Component
 */
package net.ibizsys.pscore.srv.dedesign.service;

import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFUIMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFUIModeServiceBase;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDEInitCfg;
import net.ibizsys.pscore.srv.util.PSModelGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class PSDEFUIModeService
extends PSDEFUIModeServiceBase
implements IPSModelService<PSDEFUIMode> {
    private static final Log log = LogFactory.getLog(PSDEFUIModeService.class);
    public static final String RESERVERTAG_DEFAULT = "R1";
    public static final String RESERVERTAG_MOBILEDEFAULT = "R2";

    @Override
    public void initModel(String string, IEntity iEntity, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEFIELD", (boolean)true) == 0) {
            PSDEField pSDEField = new PSDEField();
            pSDEField.proxy((IDataObject)iEntity);
            PSDEInitCfg pSDEInitCfg = PSModelGlobal.getPSDEInitCfg(pSDEField.getPSDEId(), this.getSessionFactory());
            if (pSDEInitCfg != null && DataObject.getBoolValue((Integer)pSDEInitCfg.getIgnoreUIModel(), (boolean)false)) {
                return;
            }
            boolean bl = this.isEnableFolderKey(pSDEField);
            String string3 = null;
            string3 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDEField.getPSDEFieldId(), (Object)RESERVERTAG_DEFAULT) : pSDEField.getPSDEFieldId();
            PSDEFUIMode pSDEFUIMode = new PSDEFUIMode();
            pSDEFUIMode.setPSDEFUIModeId(string3);
            if (this.checkKey(pSDEFUIMode) == 0) {
                boolean bl2 = false;
                pSDEFUIMode.reset();
                pSDEFUIMode.setFTMode("DEFAULT");
                pSDEFUIMode.setPSDEFId(pSDEField.getPSDEFieldId());
                if (!this.select(pSDEFUIMode, true)) {
                    bl2 = true;
                }
                pSDEFUIMode.reset();
                pSDEFUIMode.setPSDEFUIModeName(StringHelper.format((String)"[%1$s][%2$s]", (Object)pSDEField.getPSDEFieldName(), (Object)pSDEField.getLogicName()));
                pSDEFUIMode.setPSDEFUIModeId(string3);
                pSDEFUIMode.setPSDEFId(pSDEField.getPSDEFieldId());
                if (bl2) {
                    pSDEFUIMode.setFTMode("DEFAULT");
                    pSDEFUIMode.setCodeName("Default");
                } else {
                    pSDEFUIMode.setFTMode("CUSTOM");
                }
                this.create(pSDEFUIMode);
            }
            string3 = null;
            string3 = bl ? StringHelper.format((String)"%1$s-%2$s", (Object)pSDEField.getPSDEFieldId(), (Object)RESERVERTAG_MOBILEDEFAULT) : KeyValueHelper.genUniqueId((String)pSDEField.getPSDEFieldId(), (String)"MOBILEDEFAULT");
            pSDEFUIMode = new PSDEFUIMode();
            pSDEFUIMode.setPSDEFUIModeId(string3);
            if (this.checkKey(pSDEFUIMode) == 0) {
                pSDEFUIMode.reset();
                pSDEFUIMode.setFTMode("MOBILEDEFAULT");
                pSDEFUIMode.setPSDEFId(pSDEField.getPSDEFieldId());
                if (!this.select(pSDEFUIMode, true)) {
                    pSDEFUIMode.reset();
                    pSDEFUIMode.setPSDEFUIModeName(StringHelper.format((String)"[%1$s][%2$s]\u79fb\u52a8\u7aef\u9ed8\u8ba4", (Object)pSDEField.getPSDEFieldName(), (Object)pSDEField.getLogicName()));
                    pSDEFUIMode.setPSDEFUIModeId(string3);
                    pSDEFUIMode.setPSDEFId(pSDEField.getPSDEFieldId());
                    pSDEFUIMode.setFTMode("MOBILEDEFAULT");
                    pSDEFUIMode.setCodeName("MobileDefault");
                    this.create(pSDEFUIMode);
                }
            }
        }
    }

    @Override
    public String getModelV2Tag(PSDEFUIMode pSDEFUIMode) {
        if (!StringHelper.isNullOrEmpty((String)pSDEFUIMode.getCodeName())) {
            return pSDEFUIMode.getCodeName();
        }
        return super.getModelV2Tag(pSDEFUIMode);
    }
}

