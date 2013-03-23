package br.edu.infnet.avaliacaoAcademica.domain.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.infnet.avaliacaoAcademica.domain.hibernate.property.StudentDomainProperty;

@Entity(name = StudentDomainProperty.TABLE_NAME)
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = StudentDomainProperty.COLUMN_ID_NAME)
    private int id;

    @Column(name = StudentDomainProperty.COLUMN_NAME_NAME, length = StudentDomainProperty.COLUMN_NAME_LENGHT)
    private String nome;

    @Column(name = StudentDomainProperty.COLUMN_EMAIL_NAME, length = StudentDomainProperty.COLUMN_EMAIL_LENGHT)
    private String email;

    @Column(name = StudentDomainProperty.COLUMN_USER_NAME, length = StudentDomainProperty.COLUMN_USER_LENGHT)
    private String user;

    @Column(name = StudentDomainProperty.COLUMN_PASSWORD_NAME, length = StudentDomainProperty.COLUMN_PASSWORD_LENGHT)
    private String password;

	public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result
                + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, nome=%s, email=%s, user=%s, password=%s]", id, nome, email, user, password);
    }
}
