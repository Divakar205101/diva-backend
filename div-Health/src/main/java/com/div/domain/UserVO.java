package com.div.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DIV_USER")
public class UserVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private RoleMasterVO roleMasterDO;
    
    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "FIRSTNAME")
    private String firstName;
    
    @Column(name = "LASTNAME")
    private String lastName;
    
    @Column(name = "MIDDLENAME")
    private String middleName;
    
    @Column(name = "ADHARNUMBER")
    private String adharNumber;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "MOBILENUMBER")
    private String mobileNumber;
   
    @Column(name = "LANNUMBER")
    private String lanNumber;
    
    @Column(name = "STATUS")
    private String status;
}
