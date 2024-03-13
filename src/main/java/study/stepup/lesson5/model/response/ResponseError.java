package study.stepup.lesson5.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResponseError {
    private HttpStatusCode statusCode;
    private String message;

    public ResponseError(HttpStatusCode statusCode, Exception exception) {
        this.statusCode = statusCode;
        if (statusCode != HttpStatus.OK) {
//            StringWriter sw = new StringWriter();
//            PrintWriter pw = new PrintWriter(sw);
//            exception.printStackTrace(pw);


            this.message = exception.getMessage()
                    + " Стек вызова: "
                    + Arrays.stream(exception.getStackTrace())
                    .map(s -> s.toString()).collect(Collectors.joining(" \n "))
//                    + sw.toString()
            ;
        }
    }
}