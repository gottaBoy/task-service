/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.unires.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="88d390ffbdb76f146f608c669729d81d",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="92E66630-E3B4-4E37-90D3-3F46C1E35936",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class UniResDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public UniResDefaultDSModelBase() {
        super();

        this.initAnnotation(UniResDefaultDSModelBase.class);
    }




}