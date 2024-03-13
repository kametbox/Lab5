package study.stepup.lesson5.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalPropertiesDataModel {
    String key;
    String value;
    String name;
}