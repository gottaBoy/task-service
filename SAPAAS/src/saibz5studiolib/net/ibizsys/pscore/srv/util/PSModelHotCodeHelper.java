/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.util.ArrayList;
import java.util.HashMap;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.pscore.srv.config.entity.PSModelHotCode;
import net.ibizsys.pscore.srv.config.service.PSModelHotCodeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSModelHotCodeHelper {
    private static final Log log = LogFactory.getLog(PSModelHotCodeHelper.class);
    private PSModelHotCodeContext psModelHotCodeContext = new PSModelHotCodeContext();
    private ThreadLocal<IService> service = new ThreadLocal();
    private ThreadLocal<EntityError> entityError = new ThreadLocal();
    private ThreadLocal<IEntity> entity = new ThreadLocal();
    private HashMap<String, HashMap<String, ArrayList<PSModelHotCodeEngine>>> psModelHotCodeMap = null;
    private Object psModelHotCodeMapObject = new Object();

    public Object execute(IService iService, String string, IEntity iEntity, boolean bl) throws Exception {
        return this.execute(iService, string, iEntity, null, bl);
    }

    public Object execute(IService iService, String string, IEntity iEntity, EntityError entityError, boolean bl) throws Exception {
        try {
            ArrayList<PSModelHotCodeEngine> arrayList = this.getHotCodes(iService.getDEModel().getName(), string);
            if (arrayList == null) {
                return null;
            }
            this.service.set(iService);
            this.entityError.set(entityError);
            this.entity.set(iEntity);
            for (PSModelHotCodeEngine pSModelHotCodeEngine : arrayList) {
                Object object = pSModelHotCodeEngine.invoke(iEntity);
                if (object == null) continue;
                if (bl) {
                    throw new Exception(DataObject.getStringValue((Object)object));
                }
                return object;
            }
            return null;
        }
        catch (Exception exception) {
            this.resetThreadLocal();
            throw exception;
        }
    }

    private void resetThreadLocal() {
        this.service.set(null);
        this.entityError.set(null);
        this.entity.set(null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reloadHotCodes() throws Exception {
        Object object = this.psModelHotCodeMapObject;
        synchronized (object) {
            this.psModelHotCodeMap = null;
        }
        this.getHotCodes("", "");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ArrayList<PSModelHotCodeEngine> getHotCodes(String string, String string2) throws Exception {
        synchronized (this.psModelHotCodeMapObject) {
            if (this.psModelHotCodeMap == null) {
                try {
                    this.psModelHotCodeMap = new HashMap();
                    PSModelHotCodeService pSModelHotCodeService = (PSModelHotCodeService)ServiceGlobal.getService(PSModelHotCodeService.class);
                    SelectCond selectCond = new SelectCond();
                    selectCond.set("VALIDFLAG", (Object)1);
                    selectCond.setOrderInfo("ORDER BY ORDERVALUE");
                    ArrayList<PSModelHotCode> arrayList = pSModelHotCodeService.select((ISelectCond)selectCond);
                    for (PSModelHotCode pSModelHotCode : arrayList) {
                        ArrayList<PSModelHotCodeEngine> arrayList2;
                        String string3 = pSModelHotCode.getPSModelId();
                        HashMap<String, ArrayList<PSModelHotCodeEngine>> hashMap2 = this.psModelHotCodeMap.get(string3);
                        if (hashMap2 == null) {
                            hashMap2 = new HashMap();
                            this.psModelHotCodeMap.put(string3, hashMap2);
                        }
                        if ((arrayList2 = hashMap2.get(pSModelHotCode.getEventType())) == null) {
                            arrayList2 = new ArrayList();
                            hashMap2.put(pSModelHotCode.getEventType(), arrayList2);
                        }
                        PSModelHotCodeEngine pSModelHotCodeEngine = new PSModelHotCodeEngine(pSModelHotCode);
                        arrayList2.add(pSModelHotCodeEngine);
                    }
                }
                catch (Exception exception) {
                    this.psModelHotCodeMap = null;
                    throw exception;
                }
            }
        }
        HashMap<String, ArrayList<PSModelHotCodeEngine>> hashMap = this.psModelHotCodeMap.get(string);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(string2);
    }

    private PSModelHotCodeContext getContext() {
        return this.psModelHotCodeContext;
    }

    class PSModelHotCodeContext {
        PSModelHotCodeContext() {
        }

        public IDataEntityModel getDEModel() {
            if (this.getService() == null) {
                return null;
            }
            return this.getService().getDEModel();
        }

        public IDataEntityModel getDEModel(String string) throws Exception {
            return DEModelGlobal.getDEModel((String)string);
        }

        public IService getService() {
            return (IService)PSModelHotCodeHelper.this.service.get();
        }

        public IService getService(String string) throws Exception {
            return DEModelGlobal.getDEModel((String)string).getService(this.getService().getSessionFactory());
        }

        public IEntity createEntity() throws Exception {
            return this.getDEModel().createEntity();
        }

        public IEntity createEntity(String string) throws Exception {
            return this.getDEModel(string).createEntity();
        }

        public Object create(String string) throws Exception {
            return ObjectHelper.create((String)string);
        }

        public IEntity getEntity() {
            return PSModelHotCodeHelper.this.entity.get();
        }
    }

    class PSModelHotCodeEngine {
        private CompiledScript compiled = null;

        public PSModelHotCodeEngine(PSModelHotCode pSModelHotCode) throws Exception {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("JavaScript");
            scriptEngine.put("ctx", PSModelHotCodeHelper.this.getContext());
            Compilable compilable = (Compilable)((Object)scriptEngine);
            this.compiled = compilable.compile(pSModelHotCode.getJSCode() + ";main(ctx.entity);");
        }

        public Object invoke(Object object) throws Exception {
            return this.compiled.eval();
        }
    }
}
