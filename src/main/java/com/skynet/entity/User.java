package com.skynet.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users", schema = "public")
@TypeDef(name = "skynet", typeClass = JsonBinaryType.class)
public class User {

    @Id
    private String username;

    @Embedded//необязательная аннотация
    @AttributeOverride(name = "birthDate", column = @Column(name = "birth_date"))
    private PersonalInfo personalInfo;

//    @Type(type = "com.vladmihalcea.hibernate.type.json.JsonBinaryType")//in hibernate 6 type work different
    @Type(type = "skynet")//in hibernate 6 type work different
    private String info;

    @Enumerated(EnumType.STRING)
    private Role role;
}
