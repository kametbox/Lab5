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
@Order(2)
//проверка наличия продукта для контроля Создания доп.соглашения
public class CheckProdExistsForProduct implements ChecksProduct {
    private final ProductRepository productRepository;
    public void start(ProductModel productModel) {
        if (productModel.getInstanceId()!=null) {
            //System.out.println("проверка наличия продукта для контроля Создания доп.соглашения");
            Product prod = productRepository.findFirstByNumber(productModel.getContractNumber());
            if (prod == null) throw new HttpClientErrorException( HttpStatus.NOT_FOUND
                    ,": Экземпляр продукта с параметром contractNumber <"+productModel.getContractNumber()+"> не найден");
        }
    }
}
