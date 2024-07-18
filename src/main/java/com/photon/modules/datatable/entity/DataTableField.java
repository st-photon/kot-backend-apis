package com.photon.modules.datatable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.UUID;

@Entity(name = "DataTableField")
@Table(name = "data_table_field")
@Getter
@Setter
public class DataTableField {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "data_table_field_id", updatable = false, nullable = false)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(name = "field_name", nullable = false)
    @Basic(optional = false)
    private String fieldName;

    @Column(name = "header_name", nullable = false)
    @Basic(optional = false)
    private String headerName;

    @Column(name = "is_filter", nullable = false)
    @Basic(optional = false)
    private String isFilter;
}
