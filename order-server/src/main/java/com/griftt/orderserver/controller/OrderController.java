package com.griftt.orderserver.controller;

import com.griftt.common.entity.Goods;
import com.griftt.common.entity.GoodsDto;
import com.griftt.common.entity.Order;
import com.griftt.common.feign.GoodsFeign;
import com.griftt.common.service.OrderService;
import com.griftt.productclient.client.GoodsOrderFeignClient;
import com.griftt.productclient.client.GoodsTestFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
@Slf4j
//默认的熔断返回
//@DefaultProperties(defaultFallback = "fallBack")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @Autowired
    private GoodsOrderFeignClient goodsOrderFeignClient;

    @Autowired(required = true)
    private GoodsTestFeign goodsTestFeign;


    public Goods fallBack(){
        Goods goods = new Goods();
        goods.setBatchNo("error");
        return goods;
    }
    /**
     * 服务降级不止用在服务端和还可用在自身，屏蔽各种异常，并向前端返回指定信息
     * @return
     */
    //@HystrixCommand(fallbackMethod = "fallBack")
    //服务降级超时时间默认为1秒
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds" ,value ="2000" )
    })
    @GetMapping("/goodsOne")
    public Goods getOrderGoodsById(){
        Goods goods = goodsOrderFeignClient.getGoodsById(99);
        log.info("goods={}",goods);
        return  goods;
    }



    @PostMapping("/list")
    public List<Order> getOrder(){
        return  orderService.getOrderById(56);
    }

    @RequestMapping("test")
    public String test(){
        return "ok";
    }

    /*@GetMapping("/goods")
    public List<GoodsDto> getOrderGoods(){
        List<GoodsDto> goodsList = goodsFeign.getGoodsList();
        log.info("goods={}",goodsList);
        return goodsList;
        //return  goodsFeign.getGoodsList();
    }*/

    /**
     * 正常feign测试 ，无熔断
     * @return
     */
    @GetMapping("/goodsMore")
    public List<Goods> getOrderGoodsMore(){
        List<Goods> goodsList = goodsTestFeign.getGoodsMore();
        log.info("goods={}",goodsList);
        return goodsList;
        //return  goodsFeign.getGoodsList();
    }

    /**
     *
     * 测试feign的服务降级
     * @return
     *
     */
    @GetMapping("/goodsAll")
    public List<Goods> getOrderGoodsList(){
        List<Goods> goodsList = goodsOrderFeignClient.getGoodsList();
        log.info("goodslist={}",goodsList);
        return goodsList;
        //return  goodsFeign.getGoodsList();
    }


    /**
     * 測試服務熔斷
     * @return
     */
      @HystrixCommand(commandProperties = {
            @HystrixProperty(name ="circuitBreaker.enabled" ,value ="true" ),// 启动熔断器
            @HystrixProperty(name ="circuitBreaker.requestVolumeThreshold" ,value ="10" ),//默认时间内 连续的请求次数
            @HystrixProperty(name ="circuitBreaker.sleepWindowInMilliseconds" ,value ="5000" ),//指定某个时间窗口，休眠这个时间后变为半熔断状态
            @HystrixProperty(name ="circuitBreaker.errorThresholdPercentage" ,value ="60" )//默认时间内 连续的请求次数的错误率
    })
    @GetMapping("/goodsTwo")
    public Goods testBroker(Integer a){
        if(a%2==0){
            int b=a/0;
        }
        Goods goods = goodsOrderFeignClient.getGoodsById(99);
        log.info("goods={}",goods);
        return  goods;
    }

    /**
     * 测试分布式事务jta
     * @param id
     * @param batchNo
     * @return
     */
    @GetMapping("/jta")
    public Goods testJta(Integer id,String batchNo){
       /* if(a%2==0){
            int b=a/0;
        }*/
        Goods goods = goodsOrderFeignClient.updateGoodsById(id,batchNo);
        log.info("goods={}",goods);
        return  goods;
    }

}
