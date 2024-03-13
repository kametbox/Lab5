package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.model.response.ResponseProduct;
import study.stepup.lesson5.repository.ProductRepository;
import study.stepup.lesson5.service.cheks.ChecksAgreements;
import study.stepup.lesson5.service.cheks.ChecksProduct;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateProductService {
    private final List<ChecksProduct> checksProductList;
    private final List<ChecksAgreements> checksAgreementsList;
    private final AddProductProcess addProductProcess;
    private final AddAgreementsProcess addAgreementsProcess;
    private final ProductRepository productRepository;

    private Product product;

    public ResponseProduct create(ProductModel productModel){
        System.out.println("CreateProductService.create " + "productModel.getInstanceId()= "+ productModel.getInstanceId());

        //выполняем контроли Product
        checksProductList.stream().forEach(x -> x.start(productModel));

        //выполняем контроли Agreements
        for (AgreementModel agreementModel : productModel.getInstanceArrangement()){
            checksAgreementsList.stream().forEach(x -> x.start(agreementModel));
        }

        ResponseProduct responseProduct = new ResponseProduct();

        //если не прислали ID то создаем РКО.
        if (productModel.getInstanceId()==null) {
            product = addProductProcess.add(productModel);
        } else {
            product = productRepository.findFirstByNumber(productModel.getContractNumber());
        }

        //доп.соглашения регистрируем всегда при наличии. Хоть было РКО, хоть не было
        List<Integer> listIdAgreements = addAgreementsProcess.add(productModel, product);

        //дополняем responseProduct данными из Product
        responseProduct.setInstanceId(String.valueOf(product.getId()));
        responseProduct.setRegisterId(product.getProductRegisterId().getId());
        responseProduct.setSupplementaryAgreementId(listIdAgreements);

        System.out.println(responseProduct.toString());

        return responseProduct;
    }
}
