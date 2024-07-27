package com.piotto.apiproduct.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.piotto.apiproduct.domain.enums.ClientType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String taxId;
    private Integer clientType;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Address> addresses =  new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "PHONES")
    private Set<String> phones = new HashSet<>();

    public Client() {
    }

    public Client(Integer id, String name, String email, String taxId, ClientType clientType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.taxId = taxId;
        this.clientType = clientType.getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public ClientType getClientType() {
        return ClientType.toEnum(this.clientType);
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType.getId();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
