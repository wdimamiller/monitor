package org.test.monitor.domain;

import javax.persistence.*;

@Entity
@Table(name="service",  uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length=11, nullable=false, unique=true)
    private Long id;

    @Column(name = "host", nullable=false)
    private String host;

    @Column(name = "port", nullable=false)
    private String port;



    public Service(Long id, String host, String port) {
        super();
        this.id = id;
        this.host = host;
        this.port = port;
    }

    public Service(String host, String port) {
        super();
        this.host = host;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Service() {

        super();
    }


}
