package study.stepup.lesson5.service.cheks;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.ProductRepository;


@Component
@RequiredArgsConstructor
@Order(3)
//проверка наличия продукта для контроля Создания доп.соглашения
public class CheckProdExists implements ChecksProduct {
    private final ProductRepository productRepository;
    public void start(Object object) {

        ProductModel productModel = (ProductModel) object;
        if (productModel.getInstanceId()!=null) {
            Product prod = productRepository.findFirstByNumber(productModel.getContractNumber());
            System.out.println("проверка наличия продукта для контроля Создания доп.соглашения");
            if (prod == null) throw new HttpClientErrorException( HttpStatus.NOT_FOUND
                    ,": Экземпляр продукта с параметром instanceId <"+productModel.getInstanceId()+"> не найден");
        }
    }
}
