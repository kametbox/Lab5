package study.stepup.lesson5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.stepup.lesson5.model.data.Agreement;
import study.stepup.lesson5.model.data.Product;
import study.stepup.lesson5.model.data.ProductRegister;
import study.stepup.lesson5.model.data.ProductRegisterType;
import study.stepup.lesson5.model.request.AgreementModel;
import study.stepup.lesson5.model.request.ProductModel;
import study.stepup.lesson5.repository.AgreementsRepository;
import study.stepup.lesson5.repository.ProductRegisterRepository;
import study.stepup.lesson5.repository.ProductRegisterTypeRepository;
import study.stepup.lesson5.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class AddAgreementsProcess {
    private final AgreementsRepository agreementsRepository;
    public List<Integer> add(ProductModel productModel, Product product){

        //создаем Agreements
        System.out.println("SaveAgreements");
        List<Integer> ret = new ArrayList<>();

        for (AgreementModel agreementModel : productModel.getInstanceArrangement()){
            Agreement agreement = new Agreement();

            agreement.setProduct(product);
            agreement.setGeneralAgreementId(agreementModel.getGeneralAgreementId());
            agreement.setSupplementaryAgreementId(agreementModel.getSupplementaryAgreementId());
            agreement.setArrangementType(agreementModel.getArrangementType());
            agreement.setShedulerJobId(agreementModel.getShedulerJobId());
            agreement.setNumber(agreementModel.getNumber());
            //.............
            agreement.setCoefficient(agreementModel.getCoefficient());
            //.............

            agreementsRepository.save(agreement);
            ret.add(agreement.getId());
        }

        return ret;
    }

}
