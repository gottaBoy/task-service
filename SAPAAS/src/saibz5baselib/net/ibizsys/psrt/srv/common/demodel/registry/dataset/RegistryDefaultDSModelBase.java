/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.registry.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="6f29424570cf5cb552950326c000e031",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="18FD18E5-9F07-4F2C-B94E-D2F542AB2897",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class RegistryDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public RegistryDefaultDSModelBase() {
        super();

        this.initAnnotation(RegistryDefaultDSModelBase.class);
    }




}