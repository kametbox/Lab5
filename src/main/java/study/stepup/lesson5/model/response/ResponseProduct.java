package study.stepup.lesson5.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseProduct {
    private String instanceId;
    private String registerId;
    private List<Integer> supplementaryAgreementId = new ArrayList<>();
}