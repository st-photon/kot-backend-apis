package com.photon.modules.datatable.repository;

import com.photon.modules.datatable.entity.DataTableField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DataTableFieldRepository extends JpaRepository<DataTableField, UUID> {
}
