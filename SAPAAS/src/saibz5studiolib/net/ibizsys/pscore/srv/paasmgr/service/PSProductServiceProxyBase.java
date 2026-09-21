/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IInheritDEServiceProxy
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.paasmgr.entity.PSProduct;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysProduct;
import net.ibizsys.pscore.srv.paasmgr.service.PSProductService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysProductService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSProductServiceProxyBase
extends PSProductService<PSProduct>
implements IInheritDEServiceProxy<PSProduct> {
    private static final Log log = LogFactory.getLog(PSProductServiceProxyBase.class);

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
        ServiceGlobal.registerService((String)(this.getServiceId() + "Proxy"), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.paasmgr.service.PSProductService";
    }

    public void remove(PSProduct pSProduct) throws Exception {
        if (pSProduct.getPSProductType() == null) {
            this.get((IEntity)pSProduct);
        }
        if (StringHelper.compare((String)pSProduct.getPSProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSSysProduct pSSysProduct = new PSSysProduct();
            pSSysProduct.setPSSysProductId(pSProduct.getPSProductId());
            pSSysProductService.remove((IEntity)pSSysProduct);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSProduct.getPSProductType()));
    }

    public PSProduct getReal(PSProduct pSProduct, boolean bl) throws Exception {
        if (pSProduct.getPSProductType() == null && !this.get((IEntity)pSProduct, bl)) {
            return null;
        }
        if (StringHelper.compare((String)pSProduct.getPSProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSSysProduct pSSysProduct = new PSSysProduct();
            pSSysProduct.setPSSysProductId(pSProduct.getPSProductId());
            if (!pSSysProductService.get((IEntity)pSSysProduct, bl)) {
                return null;
            }
            return pSSysProduct;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSProduct.getPSProductType()));
    }

    public IService getRealService(PSProduct pSProduct) throws Exception {
        if (pSProduct.getPSProductType() == null) {
            this.get((IEntity)pSProduct);
        }
        if (StringHelper.compare((String)pSProduct.getPSProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
            return pSSysProductService;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSProduct.getPSProductType()));
    }

    protected void onExportCurModel(PSProduct pSProduct, ArrayList<JSONObject> arrayList) throws Exception {
        if (StringHelper.compare((String)pSProduct.getPSProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSSysProductService pSSysProductService = (PSSysProductService)ServiceGlobal.getService(PSSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSSysProduct pSSysProduct = new PSSysProduct();
            pSSysProduct.setPSSysProductId(pSProduct.getPSProductId());
            pSSysProductService.exportModel((IEntity)pSSysProduct, arrayList);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSProduct.getPSProductType()));
    }
}

