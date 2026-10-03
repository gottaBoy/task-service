/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.common.demodel.pvpart.dataset;


import net.ibizsys.paas.core.DEDataSet;
import net.ibizsys.paas.core.DEDataSetQuery;
import net.ibizsys.paas.sysmodel.CodeListGlobal;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.demodel.DEDataSetGroupParamModel;

@DEDataSet(id="d1ce1f760d77192f620b4f6b9d7769f8",name="DEFAULT",queries= {
    @DEDataSetQuery(queryid="306522FB-7103-4DDC-B334-51BC3D1AFF10",queryname="DEFAULT")
})

/**
 *  实体数据集合[DEFAULT]模型基类
 */
public abstract class PVPartDefaultDSModelBase extends net.ibizsys.paas.demodel.DEDataSetModelBase {
    public PVPartDefaultDSModelBase() {
        super();

        this.initAnnotation(PVPartDefaultDSModelBase.class);
    }




}