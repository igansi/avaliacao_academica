package br.edu.infnet.avaliacaoAcademica.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.infnet.avaliacaoAcademica.hibernate.domain.property.StudentDomainProperty;

@Entity(name = StudentDomainProperty.TABLE_NAME)
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StudentDomainProperty.COLUMN_ID_NAME)
    private int id;

    @Column(name = StudentDomainProperty.COLUMN_NAME_NAME, length = StudentDomainProperty.COLUMN_NAME_LENGHT)
    private String name;

    @Column(name = StudentDomainProperty.COLUMN_EMAIL_NAME, length = StudentDomainProperty.COLUMN_EMAIL_LENGHT)
    private String email;

    @Column(name = StudentDomainProperty.COLUMN_USER_NAME, length = StudentDomainProperty.COLUMN_USER_NAME_LENGHT)
    private String userName;

    @Column(name = StudentDomainProperty.COLUMN_PASSWORD_NAME, length = StudentDomainProperty.COLUMN_PASSWORD_LENGHT)
    private String password;

	public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, nome=%s, email=%s, user=%s, password=%s]", id, name, email, userName, password);
    }
}
