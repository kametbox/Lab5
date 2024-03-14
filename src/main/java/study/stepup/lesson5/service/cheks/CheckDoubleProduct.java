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
//контролируем Product на дубли
public class CheckDoubleProduct implements ChecksProduct {
    private final ProductRepository productRepository;
    public void start(ProductModel productModel) {
        if (productModel.getInstanceId()==null) {
            Product prod = productRepository.findFirstByNumber(productModel.getContractNumber());
            System.out.println("контролируем Product на дубли");
            if (prod != null) throw new HttpClientErrorException( HttpStatus.BAD_REQUEST
                    ,": Параметр ContractNumber № договора <"+productModel.getContractNumber()+"> уже существует для ЭП с ИД  <"+prod.getId()+">");
        }
    }
}
