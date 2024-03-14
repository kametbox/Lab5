package study.stepup.lesson5.service.cheks;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import study.stepup.lesson5.model.data.Agreement;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.AgreementsRepository;
import study.stepup.lesson5.repository.ProductRepository;


@Component
@RequiredArgsConstructor
@Order(5)
//контролируем Agreements на дубли
public class CheckDoubleAgreements implements ChecksProduct {
    private final ProductRepository productRepository;
    private final AgreementsRepository agreementsRepository;
    public void start(ProductModel productModel) {
        //если ID РКО не было задано, то у нас новый РКО и у него еще нет доп.согласшений
        if (productModel.getInstanceId()!=null) {
            for (AgreementModel agreementModel : productModel.getInstanceArrangement()) {
                Product prod = productRepository.findFirstByNumber(productModel.getContractNumber());
                Agreement agreement = agreementsRepository.findFirstByProductAndNumber(prod, agreementModel.getNumber());
                System.out.println("контролируем Agreements на дубли");
                if (agreement != null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST
                        , ": Параметр № Дополнительного соглашения (сделки) Number <" + agreementModel.getNumber()
                        + "> уже существует для ЭП с ИД  <" + productModel.getInstanceId() + ">");
            }
        }
    }
}
