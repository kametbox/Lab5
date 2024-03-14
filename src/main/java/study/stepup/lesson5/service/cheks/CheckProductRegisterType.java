package study.stepup.lesson5.service.cheks;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.ProductRegisterType;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.ProductRegisterTypeRepository;


@Component
@RequiredArgsConstructor
@Order(4)
//Проверяем что существует указанный тип счета/код продукта
public class CheckProductRegisterType implements ChecksProduct {
    private final ProductRegisterTypeRepository productRegisterTypeRepository;
    public void start(ProductModel productModel) {
        if (productModel.getInstanceId()==null) {
            ProductRegisterType productRegisterType = productRegisterTypeRepository.findFirstByProductClassCode_ValueAndAccountType_Value(productModel.getProductCode(),"Клиентский");
            System.out.println("Проверяем что существует указанный тип счета/код продукта");
            if (productRegisterType == null) throw new HttpClientErrorException(HttpStatus.NOT_FOUND
                    , ": КодПродукта <" + productModel.getProductCode() + "> не найдено в Каталоге продуктов");
        }
    }
}
