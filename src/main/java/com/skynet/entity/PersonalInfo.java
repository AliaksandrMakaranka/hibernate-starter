package com.skynet.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
/**
 Встраиваемый (Embeddable) класс это класс который не используется сам по себе,
 только как часть одного или нескольких Entity классов.
 Entity класс могут содержать как одиночные встраиваемые классы,
 так и коллекции таких классов. Также такие классы могут быть использованы как ключи или значения map
 **/
public class PersonalInfo implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String firstname;
    private String lastname;

//    @Column(name = "birth_date")
    private Birthday birthDate;
}
