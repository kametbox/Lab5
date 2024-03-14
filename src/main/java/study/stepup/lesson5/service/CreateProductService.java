package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.model.response.ResponseProduct;
import study.stepup.lesson5.repository.ProductRepository;
import study.stepup.lesson5.service.cheks.ChecksProduct;
import study.stepup.lesson5.service.cheks.ChecksRequestModel;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateProductService {
    private final List<ChecksProduct> checksProductList;
    private final List<ChecksRequestModel> checksRequestModelList;
    private final AddProductProcess addProductProcess;
    private final AddAgreementsProcess addAgreementsProcess;
    private final ProductRepository productRepository;


    public ResponseProduct create(ProductModel productModel){
        System.out.println("CreateProductService.create " + "productModel.getInstanceId()= "+ productModel.getInstanceId());

        //контроль модели на обязательность реквизитов
        checksRequestModelList.forEach(x -> x.start(productModel));
        //выполняем контроли Product
        checksProductList.forEach(x -> x.start(productModel));

        //если не прислали ID то создаем РКО.
        Product product;
        if (productModel.getInstanceId()==null) {
            product = addProductProcess.add(productModel);
        } else {
            product = productRepository.findFirstByNumber(productModel.getContractNumber());
        }

        //доп.соглашения регистрируем всегда при наличии. Хоть было РКО, хоть не было
        List<Integer> listIdAgreements = addAgreementsProcess.add(productModel, product);

        //дополняем responseProduct данными из Product
        ResponseProduct responseProduct = new ResponseProduct();
        responseProduct.setInstanceId(String.valueOf(product.getId()));
        responseProduct.setRegisterId(String.valueOf(product.getProductRegisterId().getId()));
        responseProduct.setSupplementaryAgreementId(listIdAgreements);

        System.out.println(responseProduct);

        return responseProduct;
    }
}
