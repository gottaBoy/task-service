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
package net.ibizsys.pscore.srv.devcenter.service;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IInheritDEServiceProxy;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCProduct;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysProduct;
import net.ibizsys.pscore.srv.devcenter.service.PSDCProductService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysProductService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCProductServiceProxyBase
extends PSDCProductService<PSDCProduct>
implements IInheritDEServiceProxy<PSDCProduct> {
    private static final Log log = LogFactory.getLog(PSDCProductServiceProxyBase.class);

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
        ServiceGlobal.registerService((String)(this.getServiceId() + "Proxy"), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.devcenter.service.PSDCProductService";
    }

    public void remove(PSDCProduct pSDCProduct) throws Exception {
        if (pSDCProduct.getPSDCProductType() == null) {
            this.get((IEntity)pSDCProduct);
        }
        if (StringHelper.compare((String)pSDCProduct.getPSDCProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSDCSysProductService pSDCSysProductService = (PSDCSysProductService)ServiceGlobal.getService(PSDCSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSDCSysProduct pSDCSysProduct = new PSDCSysProduct();
            pSDCSysProduct.setPSDCSysProductId(pSDCProduct.getPSDCProductId());
            pSDCSysProductService.remove((IEntity)pSDCSysProduct);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDCProduct.getPSDCProductType()));
    }

    public PSDCProduct getReal(PSDCProduct pSDCProduct, boolean bl) throws Exception {
        if (pSDCProduct.getPSDCProductType() == null && !this.get((IEntity)pSDCProduct, bl)) {
            return null;
        }
        if (StringHelper.compare((String)pSDCProduct.getPSDCProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSDCSysProductService pSDCSysProductService = (PSDCSysProductService)ServiceGlobal.getService(PSDCSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSDCSysProduct pSDCSysProduct = new PSDCSysProduct();
            pSDCSysProduct.setPSDCSysProductId(pSDCProduct.getPSDCProductId());
            if (!pSDCSysProductService.get((IEntity)pSDCSysProduct, bl)) {
                return null;
            }
            return pSDCSysProduct;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDCProduct.getPSDCProductType()));
    }

    public IService getRealService(PSDCProduct pSDCProduct) throws Exception {
        if (pSDCProduct.getPSDCProductType() == null) {
            this.get((IEntity)pSDCProduct);
        }
        if (StringHelper.compare((String)pSDCProduct.getPSDCProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSDCSysProductService pSDCSysProductService = (PSDCSysProductService)ServiceGlobal.getService(PSDCSysProductService.class, (SessionFactory)this.getSessionFactory());
            return pSDCSysProductService;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDCProduct.getPSDCProductType()));
    }

    protected void onExportCurModel(PSDCProduct pSDCProduct, ArrayList<JSONObject> arrayList) throws Exception {
        if (StringHelper.compare((String)pSDCProduct.getPSDCProductType(), (String)"SYSTEM", (boolean)true) == 0) {
            PSDCSysProductService pSDCSysProductService = (PSDCSysProductService)ServiceGlobal.getService(PSDCSysProductService.class, (SessionFactory)this.getSessionFactory());
            PSDCSysProduct pSDCSysProduct = new PSDCSysProduct();
            pSDCSysProduct.setPSDCSysProductId(pSDCProduct.getPSDCProductId());
            pSDCSysProductService.exportModel((IEntity)pSDCSysProduct, arrayList);
            return;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u7ee7\u627f\u7c7b\u578b[%1$s]", (Object)pSDCProduct.getPSDCProductType()));
    }
}

