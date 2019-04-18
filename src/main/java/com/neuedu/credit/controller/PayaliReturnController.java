package com.neuedu.credit.controller;

import com.neuedu.credit.Service.OrderService;
import com.neuedu.credit.pojo.SpecialEntity.AliReturnPayBean;
import com.neuedu.credit.pojo.enums.PayStatus;
import com.neuedu.credit.util.PayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created by elvin on 2018/10/10 17:26.
 * @Describe:
 */
@Controller
@RequestMapping(value = "/returnPay")
public class PayaliReturnController {
    private static Logger logger = LoggerFactory.getLogger(PayaliReturnController.class);
    @Autowired
    private OrderService orderService;

    /**
     * 支付宝回调的接口
     *
     * @param returnPay 支付宝回调接口返回的数据包
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/aliReturnPay", method = RequestMethod.POST)
    public void returnPay(HttpServletResponse response, AliReturnPayBean returnPay, HttpServletRequest req)
            throws IOException {
        response.setContentType("type=text/html;charset=UTF-8");
        logger.info("****************************************支付宝的的回调函数被调用******************************");
        if (!PayUtil.checkSign(req)) {
            logger.info("****************************************验签失败*******************************************");
            response.getWriter().write("failture");
            return;
        }
        if (returnPay == null) {
            logger.info("支付宝的returnPay返回为空");
            response.getWriter().write("success");
            return;
        }
        logger.info("支付宝的returnPay" + returnPay.toString());
        if (returnPay.getTrade_status().equals("TRADE_SUCCESS")) {
            logger.info("支付宝的支付状态为TRADE_SUCCESS");
//            tbPaymentRecordsService.aliPaySuccess(returnPay);
            orderService.changeStatus(returnPay.getOut_trade_no(), PayStatus.STATUS_CODE_UNPROCESSED.getCode());
        }
        response.getWriter().write("success");
    }
}
