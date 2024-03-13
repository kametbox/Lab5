package study.stepup.lesson5.logic;

import org.springframework.stereotype.Component;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.response.ResponseProduct;


@Component
public class ResponseProductCreate {
    public void create(Product product, ResponseProduct responseProduct) {
        responseProduct.setInstanceId(Integer.toString(product.getId()));
        System.out.println(product);
        responseProduct.setRegisterId(product.getProductRegisterId().getId());
        //product.getAgreements().stream().forEach(x-> responseProduct.addAgreement(x.getId()));
    }
}
