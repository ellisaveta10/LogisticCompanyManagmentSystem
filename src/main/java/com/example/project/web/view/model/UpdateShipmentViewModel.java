package com.example.project.web.view.model;

import com.example.project.data.entity.Address;
import com.example.project.data.entity.Clients;
import com.example.project.data.entity.OfficeEmployee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Positive;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateShipmentViewModel {
    /*@NotBlank(message = "Sender name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Sender has to start with capital letter!")*/
    private Clients sender;

    /*@NotBlank(message = "Receiver name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Receiver has to start with capital letter!")*/
    private Clients receiver;

    /*@NotBlank(message = "Address name cannot be blank!")
    @Size(min = 2, max = 20, message="Min length: 2, max length: 20")
    @Pattern(regexp = "^([A-Z]).*", message = "Address has to start with capital letter!")*/
    private Address address;

    /*@Positive
    @NotNull
    @Min(value = 0L, message = "The value must be positive")*/
    private double weight;

    private OfficeEmployee officeEmployee;
}
