package com.neuedu.credit.controller;

import com.neuedu.credit.Service.OrderService;
import com.neuedu.credit.Service.ProductService;
import com.neuedu.credit.config.security.SessionConfig;
import com.neuedu.credit.pojo.OrderProduct;
import com.neuedu.credit.pojo.PaymentOrder;
import com.neuedu.credit.pojo.Product;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.enums.PayStatus;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import com.neuedu.credit.util.PayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Created by elvin on 2018/10/8 8:43.
 * @Describe: 订单
 */
@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    SessionConfig sessionConfig;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;


    /**
     * @return
     * @Created elvin yuan on 15:46 2018/10/9
     * @Describe //TODO
     * 统一按照单价处理，针对不同客户的优惠政策，采用预存赠费方式;
     * 获取数据库产品信息进行对比，计算产品*数量 并求和与订单总价进行比较
     * @Param @RequestParam("productId") 中的 productId 与 请求参数对应
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addOrder(PaymentOrder order, @RequestParam("productId") int[] products, @RequestParam int[] counts, HttpServletRequest request) {
        if (products.length < 1 || counts.length < 1) {
            return new ResponseEntity(ResponseEnum.FAILED, "订单未正常添加要购买的产品");
        }
        //
        double totalCalculation = 0.00;
        String orderId = generateOrderId();
        OrderProduct[] orderProducts = new OrderProduct[products.length];
        for (int i = 0; i < products.length; i++) {
            Product product = productService.findById(products[i]);
            if (product.getState() == 0) {
                return new ResponseEntity(ResponseEnum.FAILED, product.getName() + "产品已下架");
            }
            totalCalculation += product.getPrice()* counts[i];
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setPid(products[i]);
            orderProduct.setCount(counts[i]);
            orderProduct.setUnitprice(product.getPrice());
            orderProduct.setOrderno(orderId);
            orderProducts[i] = orderProduct;
        }
        if (order.getAmount() != totalCalculation) {
            return new ResponseEntity(ResponseEnum.FAILED, "订单价格有误");
        }
        //amount、shipping 已有 / paytype、donetime 暂不需要
        order.setStatus(PayStatus.STATUS_CODE_NOT_PAID.getCode());
        order.setUserId(sessionConfig.getUserId());
        order.setUserIp(request.getRemoteAddr());
        order.setCreatetime(new Timestamp(new Date().getTime()));
        order.setOrderno(orderId);
        orderService.add(order, orderProducts);

        return new ResponseEntity(ResponseEnum.SUCESSFUL, order);
    }

    @RequestMapping("/get/{orderId}")
    public String getOrder(@PathVariable String orderId, Model map) {
        PaymentOrder order = orderService.get(orderId);
        List<OrderProduct> orderProducts = orderService.getOrderProducts(orderId);
        map.addAttribute("order", order);
        map.addAttribute("products", orderProducts);
        return "order/detail";
    }

    @RequestMapping(value = "/payform", method = RequestMethod.POST)
    public String payOrder(PaymentOrder order,Model model) throws IOException {
        order.setOrderno("1539077167033767");
        order.setAmount(300.00);
        String str = PayUtil.alipay(order.getOrderno(), String.valueOf(order.getAmount()), "购买信用产品", "test");
        model.addAttribute("paybody",str);
        return "order/alipay";
    }

    /**
     * 通过时间戳+3位随机数方式，生成订单号，高并发须加进程Id
     * BigDecimal.ROUND_HALF_UP &ge >= 0.5 即进位
     *
     * @return
     */
    private String generateOrderId() {
        long timeStamp = System.currentTimeMillis();
        double rand = Math.random() * 900 + 100;
        StringBuilder builder = new StringBuilder();
        BigDecimal bd = new BigDecimal(rand).setScale(0, BigDecimal.ROUND_HALF_UP);
        builder.append(timeStamp).append(Integer.parseInt(bd.toString()));
        return builder.toString();
    }
}
