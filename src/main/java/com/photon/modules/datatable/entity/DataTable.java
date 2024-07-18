package com.photon.modules.datatable.entity;

import com.photon.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.io.Serializable;
import java.util.UUID;

@Entity(name = "DataTable")
@Table(name = "data_table")
@Getter
@Setter
public class DataTable extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "data_table_id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(name = "code", nullable = false, unique = true)
    @Basic(optional = false)
    private String code;

    @Column(name = "name", nullable = false)
    @Basic(optional = false)
    private String name;
}
