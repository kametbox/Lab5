package study.stepup.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.request.AdditionalPropertiesModel;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.AgreementsRepository;
import study.stepup.lesson5.repository.ProductRegisterRepository;
import study.stepup.lesson5.repository.ProductRegisterTypeRepository;
import study.stepup.lesson5.repository.ProductRepository;
import study.stepup.lesson5.service.AddAgreementsProcess;
import study.stepup.lesson5.service.AddProductProcess;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Save2BdTest {
    AgreementsRepository repoAgreements;
    ProductModel productModel;
    AddProductProcess addProductProcess;
    ProductRepository productRepository;
    ProductRegisterRepository productRegisterRepository;
    ProductRegisterTypeRepository productRegisterTypeRepository;

    @Autowired
    public Save2BdTest(AgreementsRepository repoAgreements, AddProductProcess addProductProcess, ProductRepository productRepository, ProductRegisterRepository productRegisterRepository, ProductRegisterTypeRepository productRegisterTypeRepository) throws ParseException {
        this.repoAgreements = repoAgreements;
        this.addProductProcess = addProductProcess;
        this.productRepository = productRepository;
        this.productRegisterRepository = productRegisterRepository;
        this.productRegisterTypeRepository = productRegisterTypeRepository;

        productModel = new ProductModel(
                  2
                , "ДОГОВОР"
                , "03.012.002"
                , "03.012.002_47533_ComSoLd"
                , "15"
                , "2024-01-10-000001"
                , new SimpleDateFormat("yyyy-MM-dd").parse("2024-01-10")
                , 2
                , 12.25F
                , 0F
                , 0F
                , "qwerty"
                , "0"
                , 13F
                , 1000F
                , 112233
                , "0022"
                , "800"
                , "00"
                , 1234
                , new AdditionalPropertiesModel()
                , new ArrayList<>(List.of(new AgreementModel())));
    }

    @Test
    public void AddProduct_Test() {
        productRepository.deleteAll();
        productRegisterRepository.deleteAll();

        new AddProductProcess(productRepository, productRegisterRepository, productRegisterTypeRepository).add(productModel);

        Assertions.assertTrue(productRepository.count() > 0);
        Assertions.assertTrue(productRegisterRepository.count() > 0);
    }

    @Test
    public void SaveAgreements_Test() {
        productRepository.deleteAll();

        Product product1 = new AddProductProcess(productRepository, productRegisterRepository, productRegisterTypeRepository).add(productModel);

        repoAgreements.deleteAll();

        new AddAgreementsProcess(repoAgreements).add(productModel, product1);

        Assertions.assertTrue(repoAgreements.count() > 0);
    }

}
