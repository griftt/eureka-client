package com.griftt.common.service.impl.ordergoods;

import com.griftt.common.entity.Order;
import com.griftt.common.service.OrderGoodsService;
import org.bytesoft.bytetcc.supports.spring.aware.CompensableContextAware;
import org.bytesoft.compensable.Compensable;
import org.bytesoft.compensable.CompensableContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * try
 * CompensableContextAware:
 * 尽管Confirm/Cancel阶段的执行会使用和Try阶段一样的参数，有时候将try阶段的计算结果直接传递给confirm/cancel阶段使用还是有必要的。例如，处于性能的考虑不想在confirm/cancel阶段再次计算数据的状态，又或者confirm/cancel阶段无法计算出try阶段执行时的历史状态时，可以考虑将临时结果放置在CompensableContext变量中供confirm/cancel阶段直接使用
 */
@Service
/*@Compensable(
        interfaceClass = OrderGoodsService.class,
        cancellableKey ="orderGoodsConfirmKey",
        confirmableKey = "orderGoodsCancelkey"
)*/
public class OrderGoodsServiceImpl implements OrderGoodsService , CompensableContextAware {
    private CompensableContext compensableContext;

    @Override
    public void setCompensableContext(CompensableContext compensableContext) {
        this.compensableContext=compensableContext;
    }

    @Override
    @Transactional
    public void increaseOrderGoods(Integer goodsId, Order order) {

        /**
         * 传递try阶段的方法
         */
        this.compensableContext.setVariable("resultInTryPhase", "1");
    }
}
