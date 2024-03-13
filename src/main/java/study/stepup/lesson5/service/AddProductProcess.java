package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.data.ProductRegister;
import study.stepup.lesson5.model.data.ProductRegisterType;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.ProductRegisterRepository;
import study.stepup.lesson5.repository.ProductRegisterTypeRepository;
import study.stepup.lesson5.repository.ProductRepository;


@Component
@RequiredArgsConstructor
public class AddProductProcess {
    private final ProductRepository productRepository;
    private final ProductRegisterRepository productRegisterRepository;
    private final ProductRegisterTypeRepository productRegisterTypeRepository;

    public Product add(ProductModel productModel){

        //создаем Product, дополняем responseProduct данными из Product
        Product product = new Product();
        ProductRegister productRegister = new ProductRegister();

        System.out.println("Add Product and Add ProductRegister");
        product.setType(productModel.getProductType());
        product.setNumber(productModel.getContractNumber());
        product.setDateOfConclusion(productModel.getContractDate());
        product.setPenalty_rate(productModel.getInterestRatePenalty());
        product.setNso(productModel.getMinimalBalance());
        product.setThresholdAmount(productModel.getThresholdAmount());
        product.setInterestRateType(productModel.getRateType());
        product.setTaxRate(productModel.getTaxPercentageRate());
        product.setProductRegisterId(productRegister);

        productRepository.save(product);

        //наполняем ProductRegister
        System.out.println("SaveProductRegister");
        ProductRegisterType productRegisterType = productRegisterTypeRepository.findFirstByProductClassCode_ValueAndAccountType_Value(productModel.getProductCode(),"Клиентский");
        System.out.println("productRegisterType= "+ productRegisterType.toString());

        productRegister.setProductId(product);
        productRegister.setType(productRegisterType);
        productRegister.setCurrencyCode(productModel.getIsoCurrencyCode());
        productRegister.setState("Create");

        productRegisterRepository.save(productRegister);

        return product;
    }

}
