package modals;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Contact {

    String name;
    String lastname ;
    String phone;
    String email;
    String address;
    String description;


}
