package study.stepup.lesson5.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalPropertiesModel {
    ArrayList<AdditionalPropertiesDataModel> data;
}
