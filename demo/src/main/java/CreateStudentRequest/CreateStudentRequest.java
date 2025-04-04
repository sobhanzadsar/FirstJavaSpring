package CreateStudentRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequest {

	@JsonProperty("first_name")
	private String firstName;

	private String lastName;

	private String email;

}
